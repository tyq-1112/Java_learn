package Java三.集合输出;

import com.sun.xml.internal.bind.v2.runtime.reflect.ListIterator;

import java.awt.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Iterator1 {
    public static void main(String[] args) {
        Set<String> all = new HashSet<>();
        all.add("java");
        all.add("php");
        all.add("python");
        all.add("java");
        Iterator<String> iterator = all.iterator();
        while(iterator.hasNext()){
            String str = iterator.next();
            if(str.equals("java"))iterator.remove();         //删除当前元素
                                                             //如果使用all.remove()方法会导致迭代失败
            else System.out.println(str);
        }
    }
}
