package Java三.List集合;

import java.util.LinkedList;
import java.util.List;

public class LinkListDemo {
    public static void main(String[] args) {
        List<String> list= new LinkedList<String>() ;      //为List父接口进行实例化
        list.add("java");
        list.add("");
        list.add(null);

        list.forEach(System.out::println);
    }
}
