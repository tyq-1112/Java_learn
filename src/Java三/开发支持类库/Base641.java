package Java三.开发支持类库;

import java.util.Base64;

class Base{
    public static final String SALT = "google" ;     //公共的盐值
    public static final int REPEAT = 5 ;             //加密的次数

    /**
     * 加密处理
     * @param str 要加密的字符串，需要与盐值整合
     * @return 加密后的数据
     */
    public static String encode(String str ){     //加密处理
        String temp = str + "{" + SALT + "}" ;  //盐值对外不公布
        byte [] data = temp.getBytes();
        for (int i = 0 ; i< REPEAT ;i++){
            data = Base64.getEncoder().encode(data) ;     //重复加密
        }
        return new String(data) ;
    }

    /**
     * 解密处理
     * @param str 需要解密的数据
     * @return 解密后的数据
     */
    public static  String decode(String str){
        String data = str ;
        for (int i = 0 ; i<REPEAT ;i++){
             data = new String(Base64.getDecoder().decode(data)) ;
        }
        return data.replaceAll("\\{\\w+\\}","") ;     //盐值替换
    }
}
public class Base641 {
    public static void main(String[] args) {
        String data = Base.encode("www.baidu.com") ;
        System.out.println(data);
        System.out.println(Base.decode(data));

    }
    //如果没有加密次数和盐值，无法破解
}
