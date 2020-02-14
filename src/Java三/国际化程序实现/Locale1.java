package Java三.国际化程序实现;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

public class Locale1 {
    public static void main(String[] args) {
        Locale locale = Locale.getDefault() ;
        System.out.println(locale);      //zh_CN
        //如果资源文件不在包里面，可直接编写资源名称即可  ——123

        ResourceBundle RB = ResourceBundle.getBundle("Java三.国际化程序实现.source");
        String val = null;
        try {
            val = new String(RB.getString("info").getBytes("ISO-8859-1"),"GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // key一定要存在
        System.out.println(val);
    }
}
