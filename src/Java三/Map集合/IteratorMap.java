package Java三.Map集合;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class IteratorMap {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        Set<Map.Entry<String, Integer>> set = map.entrySet();            //将Map集合转为Set集合
        Iterator<Map.Entry<String, Integer>> iterator = set.iterator();     //Iterator的对象为Map.Entry对象
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();                //用一个Map.Entry对象接收
            System.out.println(entry.getKey() + " = " + entry.getValue());     //通过Map.Entry接口中的方法获取key，value
        }
    }
}
