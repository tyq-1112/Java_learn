package Java三.集合输出;

import java.util.Enumeration;
import java.util.Vector;

public class Enumerator1 {
    public static void main(String[] args) {
        Vector<String> all = new Vector<>();
        all.add("java");
        all.add("java");
        all.add("python");
        Enumeration<String>enumeration = all.elements();
        while(enumeration.hasMoreElements()){
            System.out.println(enumeration.nextElement());
        }

    }
}
