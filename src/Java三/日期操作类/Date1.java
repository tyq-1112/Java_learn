package Java三.日期操作类;


import java.util.Date;

public class Date1 {
    public static void main(String[] args) {
        //将long转为日期：public Date(long date) ;
        //将Date转为long：public long getTime() ;
        //long可以保存毫秒的数据级，方便程序处理
        Date date = new Date() ;
        System.out.println(date);

        long curr = date.getTime() ;
        System.out.println(new Date(curr));
        /*
        Tue Feb 11 09:39:24 CST 2020
        Tue Feb 11 09:39:24 CST 2020
         */

    }
}
