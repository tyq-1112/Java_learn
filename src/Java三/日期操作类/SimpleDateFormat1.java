package Java三.日期操作类;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * SimpleDateFormat是DateFormat的子类
 * 1.【DateFormat】将日期格式化：public final String format(Date date)
 * 2.【DateFormat】字符串转为日期：public Date parse(String source)
 * 3.【构造方法】public SimpleDateFormat(String pattern)
 * 4.年(yyyy)、月(MM)、日(dd)、时(HH)、分(mm)、秒(ss)、毫秒(SSS)
*/
public class SimpleDateFormat1 {
    public static void main(String[] args) throws ParseException {
        Date date = new Date() ;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
        String str = sdf.format(date);        //日期转为字符串
        System.out.println(str);     //2020-02-11
        //如果字符串数字超过合理范围，会自动进位处理
        String birthday = "1111-11-11";
        date = sdf.parse(birthday);     //字符串转日期
        System.out.println(date);

        double money = 12356789.2 ;
        String strformat = NumberFormat.getInstance().format(money);
        System.out.println(strformat);   //12,356,789.2

    }
}
