package Java三.正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matcher1 {
    public static void main(String[] args) {
        //要求取出"#{内容}"标记中的所有内容
        String str = "INSERT INTO dept(deptno,dname,loc) VALUES (#{deptno},#{dname},#{loc})" ;
        String regex = "#\\{\\w+\\}" ;
        Pattern pattern = Pattern.compile(regex) ;      //编译正则表达式
        Matcher matcher = pattern.matcher(str) ;
        while(matcher.find()){            //是否有匹配成功的内容
            System.out.println(matcher.group(0).replaceAll("#|\\{|\\}",""));
        }

    }
}
