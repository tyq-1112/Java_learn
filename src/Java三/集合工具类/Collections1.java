package Java三.集合工具类;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Collections1 {
    //Collections是java提供的一组集合数据的操作工具类，利用它可以实现各个集合的操作
    public static void main(String[] args) {
        //使用Collections操作List
        List<String> all = new ArrayList<>() ;
        Collections.addAll(all,"java","PHP","Python","C#") ;
        System.out.println(all); //[java, PHP, Python, C#]

        //实现数据反转
        Collections.reverse(all);
        System.out.println(all);    //[C#, Python, PHP, java]

        //二分查找
        Collections.sort(all);    //查找前排序
        System.out.println(Collections.binarySearch(all,"java"));
    }
}
/**
 * 面试题：Collection与Collections
 *  Collection：是集合接口，允许保存单值对象
 *  Collections：是集合操作的工具类
 * */
