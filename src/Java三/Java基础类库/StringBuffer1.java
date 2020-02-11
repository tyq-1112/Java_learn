package Java三.Java基础类库;

public class StringBuffer1 {
    public static void main(String[] args) {
          //StringBuffer 支持修改字符串内容
        StringBuffer buffer = new StringBuffer("www.");
        buffer.append("baidu.");             //追加数据
        buffer.append("com");
        System.out.println(buffer);

        StringBuffer buf = new StringBuffer();
        buf = buf.append(".cn").insert(0,"www.").insert(4,"sina");  //插入数据
        System.out.println(buf);

        /**
         * String类是字符串的首选类型，其最大的特点内容不允许修改
         * StringBuffer和StringBuilder内容可以修改
         * StringBuffer属于线程安全，JDK1.0的时候提供的
         * StringBuilder属于非线程安全，JDK1.5之后*/
    }
}
