package java二.Class_String;

class FirstUper
{
    public static String UperFirst(String str)
    {
        if(str==null||"".equals(str))return str;
        if(str.length()==1)return str.toUpperCase() ;
        return str.substring(0,1).toUpperCase()+str.substring(1);
    }

}
public class Split {
    public static void main(String[] args) {

        String ip = "192.168.255.254";
        String result [] = ip.split("\\.");    //遇见拆分不了的，需要加 \\
        for (String str:result
             ) {
            System.out.println(str);
        }

        //首字母大写
        String str = "hello";
        System.out.println(FirstUper.UperFirst(str));
    }
}
