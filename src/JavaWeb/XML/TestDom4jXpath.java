package JavaWeb.XML;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import javax.print.Doc;
import java.beans.XMLDecoder;
import java.io.File;
import java.util.List;

public class TestDom4jXpath {
    public static final String path = "D:\\Desktop\\Java笔记\\src\\JavaWeb\\XML\\1.xml";
    public static final File xmlsource = new File(path);

    public static void main(String[] args) throws Exception {
        selectName();
        selectFirstName();
    }

    /**
     * 得到所有的name值
     * 使用方法selectNodes();
     * -xpath: //name
     *
     * @throws DocumentException
     */
    public static void selectName() throws DocumentException {
        //得到document对象
        SAXReader reader = new SAXReader();
        Document document = reader.read(xmlsource);
        //使用selectNodes("//name")方法得到所有的name元素
        List<Node> list = document.selectNodes("//name");
        //遍历List
        for (Node node : list
        ) {
            System.out.println(node.getText());
        }
    }

    /**
     * 得到第一个student下的name值
     * 使用方法selectSingleNode()
     * -xpath : //student[@id='aaa']/name
     *
     * @throws DocumentException
     */
    public static void selectFirstName() throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(xmlsource);

        Node name1 = null;
        name1 = document.selectSingleNode("//student[@id2='aaa']/sex");
        System.out.println(name1.getText());
    }
}
