package JavaWeb.XML;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

public class TestDom4j {
    public static final String path = "D:\\Desktop\\Java笔记\\src\\JavaWeb\\XML\\1.xml";
    public static final File xmlsource = new File(path);

    public static Document getDocument() throws DocumentException {
        //创建解析器
        SAXReader reader = new SAXReader();
        //得到document
        Document document = reader.read(xmlsource);
        return document;
    }

    public static void modifyXml(Document document) throws Exception {
        XMLWriter writer = new XMLWriter(new FileOutputStream(xmlsource), OutputFormat.createPrettyPrint());
        writer.write(document);
        writer.close();
    }

    public static void main(String[] args) throws Exception {
        select();
        //addAge();
        delAge();
    }

    /**
     * 查询所有name的内容
     *
     * @throws DocumentException
     */
    public static void select() throws DocumentException {
        //得到根节点
        Document document = getDocument();
        Element root = document.getRootElement();
        //得到student
        List<Element> list = root.elements("student");
        //遍历student
        Iterator<Element> iterator = list.listIterator();
        while (iterator.hasNext()) {
            //得到每一个student
            Element student1 = iterator.next();
            //得到student下面的name元素
            System.out.println(student1.element("name").getText());
        }
    }

    /**
     * 在第一个student标签下末尾添加<age>20</age>
     *
     * @throws DocumentException
     */
    public static void addAge() throws Exception {
        Document document = getDocument();
        //得到根节点
        Element root = document.getRootElement();
        //得到第一个student
        Element student1 = root.element("student");
        //添加标签
        Element Age = student1.addElement("age");
        //添加文本
        Age.setText("20");
        //回写
        modifyXml(document);
    }

    /**
     * 删除Age标签
     *
     * @throws Exception
     */
    public static void delAge() throws Exception {
        //得到根节点
        Document document = getDocument();
        Element root = document.getRootElement();
        //得到第一个student元素
        Element student1 = root.element("student");
        //得到student下Age标签
        Element Age = student1.element("age");
        //删除Age标签
        student1.remove(Age);
        //回写
        modifyXml(document);
    }
}
