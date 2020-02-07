package Java三.List集合;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ALDemo {
    public static void main(String[] args) {
        List<String> list= new ArrayList<>() ;      //为List父接口进行实例化
        list.add("java");
        list.add("java");             //list可以保存重复数据
        list.add("c++");
        list.remove("java");

        list.forEach((str)->{
            System.out.println(str );
        });

        list.forEach(System.out::println);          //方法引用代替消费型接口
    }
}
