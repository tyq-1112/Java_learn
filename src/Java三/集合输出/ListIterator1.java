package Java三.集合输出;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator ;

public class ListIterator1 {
    public static void main(String[] args) {
        List<String> all = new ArrayList<>();
        all.add("java");
        all.add("java");
        all.add("PHP");
        all.add("Python");
        ListIterator<String> iterator = all.listIterator();
        System.out.println("由前向后输出：");
        while(iterator.hasNext()){
            String str = iterator.next();
            System.out.print(str+"  ");
        }
        System.out.println("\n由后向前输出：");
        while(iterator.hasPrevious()){
            System.out.print(iterator.previous()+"  ");
        }
    }
}
