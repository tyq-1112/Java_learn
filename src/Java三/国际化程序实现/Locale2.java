package Java三.国际化程序实现;
/**
 * 如果有指定区域的资源文件存在的时候，没有设置区域的资源文件的信息将不会被读取
 * 读取顺序：读取指定区域的资源 > 默认本地资源  > 公共的资源
 */
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Locale2 {
    public static void main(String[] args) {
        Locale Loc = new Locale("ja","JP") ;
        ResourceBundle rsb = ResourceBundle.getBundle("Java三.国际化程序实现.521",Loc) ;
        String val = null ;
        try {
            val = new String(rsb.getString("info").getBytes("ISO-8859-1"), "GBK");
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(MessageFormat.format(val,"面コード",new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
    }
}
