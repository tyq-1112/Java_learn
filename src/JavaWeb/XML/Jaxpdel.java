package JavaWeb.XML;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class Jaxpdel {
    public static void main(String[] args) throws Exception {
        del();
    }

    /**
     * 删除 sno 标签
     *
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */
    public static void del() throws Exception {
        Document document = DocumentUtils.getDocument();
        //得到sno标签
        Node sno1 = document.getElementsByTagName("sno").item(0);
        //得到sno父标签
        Node Student = sno1.getParentNode();
        //删除
        Student.removeChild(sno1);
        DocumentUtils.modifyxml(document);
    }
}
