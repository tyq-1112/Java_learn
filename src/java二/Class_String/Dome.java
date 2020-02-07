package java二.Class_String;

public class Dome {
    public static void main(String[] args) {

        String str1 = "123" ;

        String str2 = "1" + "2" + "3"  ;

        String str3 = "2" ;

        String str4 = "1" + str3 + "3" ;

        System.out.println(str1 == str2);  //true
        //str1.length()

        /*
        * 本程序之间所给出的内容全部都是常量数据（字符串的常量都是匿名对象）
        * 所以在程序加载的时候会自动帮你处理好相应的连接
        * */
        System.out.println(str1 == str4);  //false
        /*
        * 因为程序在加载的时候，程序不确定str3是什么内容，因为字符串连接的时候
        * str3采用的是变量，变量的内容可以修改，所以最终不认为str3的结果就是一个所需要的值
        * */
    }
}
