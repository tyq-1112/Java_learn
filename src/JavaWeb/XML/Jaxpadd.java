package JavaWeb.XML;

import com.mysql.cj.protocol.ResultStreamer;
import org.w3c.dom.*;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class Jaxpadd {

    /**
     * 在第一个Student添加 <sno>1809090121<sno/>
     * 1.得到document对象
     * 2.得到第一个Student
     * 3.创建sno标签 ：createElement
     * 4.创建文本：createTextNode
     * 5.把文件添加到sno下面：appendChild
     * 6.把sno添加到Student下
     * 7.回写xml
     */
    public static void main(String[] args) throws Exception {
        addsno();
    }

    public static void addsno() throws Exception {
        //得到Document对象
        Document document = DocumentUtils.getDocument();
        //得到Student标签
        NodeList list = document.getElementsByTagName("Student");
        Node Student = list.item(0);
        //创建sno标签
        Element sno1 = document.createElement("sno");
        //创建sno中内容
        Text text1 = document.createTextNode("1809090121");
        //把文本内容添加到sno标签中
        sno1.appendChild(text1);
        //把son标签添加到Student标签里
        Student.appendChild(sno1);

        //把内存中的操作写进xml文件
        DocumentUtils.modifyxml(document);
    }
}
