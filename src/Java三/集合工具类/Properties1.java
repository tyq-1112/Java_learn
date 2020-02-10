package Java三.集合工具类;

import java.util.Collections;
import java.util.Properties;

public class Properties1 {
    public static void main(String[] args) {
        Properties pro = new Properties();
        //设置内容只允许是字符串
        pro.setProperty("baidu","www.baidu.com");
        pro.setProperty("google","www.google.com");
        //key = value

        System.out.println(pro.getProperty("baidu"));
        System.out.println(pro.getProperty("sina","NoFound"));
        System.out.println(pro.getProperty("sina"));
        /** www.baidu.com
          * NoFound
          * null
          */
    }
}
