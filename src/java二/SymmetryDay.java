package java二;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SymmetryDay {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        for(int y = 2020 ; y<2100 ; y++){
            String year = String.valueOf(y);
            calendar.set(y, getValue(year,2)-1, getValue(year,0));
            String date = sdf.format(calendar.getTime());
            if(date.equals(year+new StringBuilder(year).reverse())){
                System.out.println(date);
            }
        }
    }
    private static int getValue(String year, int begin){
        return Integer.parseInt(new StringBuilder(year.substring(begin,begin+2)).reverse().toString());
    }
}
