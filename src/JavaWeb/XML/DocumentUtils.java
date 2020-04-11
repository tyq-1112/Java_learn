package JavaWeb.XML;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class DocumentUtils {
    public static final String path = "D:\\Desktop\\Java笔记\\src\\JavaWeb\\XML\\scratch.xml";

    public static Document getDocument() throws IOException, SAXException, ParserConfigurationException {
        //得到解析器工厂
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        //得到解析器
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        //解析xml文件得到Document对象
        File file = new File(path);
        Document document = builder.parse(file);
        return document;
    }

    public static void modifyxml(Document document) throws TransformerException {
        //把内存中的操作写进xml文件
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(new DOMSource(document), new StreamResult(path));
    }
}
