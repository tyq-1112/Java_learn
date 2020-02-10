package Java三.集合工具类;

import java.util.LinkedList;
import java.util.Properties;
import java.util.Queue;

public class Queue1 {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        // Queue<String> queue = new PriorityQueue<>();    //带有排序
        queue.offer("123");
        queue.add("456");         //追加队列数据，通过队尾追加
        queue.add("789");

        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }

    }
}
