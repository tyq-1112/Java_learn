package JavaWeb.XML;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * 实现jaxp 操作xml
 */
public class Jaxpfind {
    public static void main(String[] args) throws Exception {
        /**
         * 1.创建解析器工厂
         * 2.根据解析器工厂创建解析器
         * 3.解析xml返回document
         * 4.得到所有的name元素
         * 5.返回集合，遍历集合，得到每一个name元素
         */
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = builderFactory.newDocumentBuilder();

        File file = new File("D:\\Desktop\\Java笔记\\src\\JavaWeb\\XML\\scratch.xml");
        //因为路径非英文...
        Document document = builder.parse(file);

        NodeList list = document.getElementsByTagName("name");

        for (int i = 0; i < list.getLength(); i++) {
            // item 返回 Node类型，name元素
            //getTextContent ：返回String 类型，name元素里面的值
            System.out.println(list.item(i).getTextContent());
        }
    }
}
