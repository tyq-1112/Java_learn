package JavaWeb.XML;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class JaxpListElement {
    public static void main(String[] args) throws Exception {
        Document document = DocumentUtils.getDocument();
        list(document);
    }

    /**
     * 递归遍历所有标签
     *
     * @param node
     */
    private static void list(Node node) {
        //判断元素类型
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            System.out.println(node.getNodeName());
        }
        //得到一层子标签
        NodeList list = node.getChildNodes();

        //遍历list
        for (int i = 0; i < list.getLength(); i++) {
            Node node1 = list.item(i);
            list(node1);
        }
    }
}
