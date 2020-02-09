package Java三.Map集合;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashMap1 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("one",1);
        map.put("two",2);
        map.put("three",3);
        map.put("one",11);               //key重复
        map.put(null,0);                 //key为空
        map.put("zero",null);            //value为空

        System.out.println(map.get("one"));            //key存在
        System.out.println(map.get(null));             //key为空
        System.out.println(map.get("four"));          //key不存在
        System.out.println(map.toString());
        /**
         * 11            如果重复会用新的key覆盖旧的
         * 0             也可以保存key或者value为空
         * null
         * */

    }
}
