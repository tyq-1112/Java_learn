package Java三.数字操作类;
//大数字操作类：BigInteger、BigDecimal
import java.math.BigInteger;

public class BigInteger1 {
    public static void main(String[] args) {
        BigInteger A = new BigInteger("123456789987654321") ;
        BigInteger B = new BigInteger("123456789");
        System.out.println("加法："+A.add(B));
        System.out.println("减法："+A.subtract(B));
        System.out.println("乘法："+A.multiply(B));
        System.out.println("除法："+A.divide(B));

        //求余数，第一个元素为商，第二个为余数
        BigInteger res[] = A.divideAndRemainder(B);
        System.out.println("商、"+res[0]+"\n余、"+res[1]);
    }

    //Math的处理使用的是基本数据类型，所以性能高于大数字处理类
}
