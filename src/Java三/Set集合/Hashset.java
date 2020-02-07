package Java三.Set集合;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Hashset {
    public static void main(String[] args) {
        Set<String> hashset = new HashSet<>();
        hashset.add("java");
        hashset.add("java");
        hashset.add("python");
        hashset.add("C#");
        hashset.add("c++");
        hashset.forEach(System.out::print);
        System.out.println();
        //输出结果与保存顺序不一致，无序
        //不保存重复数据


    }
}
