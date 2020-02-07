package Java三.Set集合;

import java.util.Set;
import java.util.TreeSet;

public class Treeset {
    public static void main(String[] args) {
        Set<String> treeset = new TreeSet<>();
        treeset.add("B");
        treeset.add("B");
        treeset.add("A");
        treeset.add("D");
        treeset.forEach(System.out::println);
         //res：ABD
        //自动按照数据的升序进行排序
    }
}
