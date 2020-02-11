package Java三.正则表达式;
//正则表达式无法对内容进行处理，只能对格式进行处理
public class regex2 {
    public static void main(String[] args) {
        String str1 = "13sd46sd6#$%^&s46d1s6sd4" ;
        //删除非字母和数字
        String regex1 = "[^a-zA-Z0-9]+" ;
        System.out.println(str1.replaceAll(regex1,""));  //13sd46sd6s46d1s6sd4

        String str2 = "a1b22c333d4444e55555f666666g";
        //按照数字拆分
        String regex2 = "\\d+";
        String res[] = str2.split(regex2);
        for (String temp:res
             ) {
            System.out.print(temp + "、");      //a、b、c、d、e、f、g、
        }

        String str3 = "100.001";
        //判断是否为小数
        String regex3 = "\\d+(\\.\\d+)?" ;    //  \\d+表示多位数字，(\\.\\d+)? 表示小数点和后面多位数字出现0次或1次
        System.out.println(str3.matches(regex3));          //true
    }
}
