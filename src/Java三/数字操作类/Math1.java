package Java三.数字操作类;

class MathUtil{
    private MathUtil(){}

    /**
     * 实现数据的四舍五入操作
     * @param num 要进行四舍五入的数
     * @param scale 四舍五入保留的位数
     * @return 四舍五入的处理结果
     */
    public static double round(double num , int scale){
        return Math.round(num * Math.pow(10,scale)) / Math.pow(10,scale) ;
    }
}
public class Math1 {
    public static void main(String[] args) {
        System.out.println(MathUtil.round(19.8697,2));
    }
}
