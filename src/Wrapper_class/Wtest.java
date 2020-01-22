package Wrapper_class;

class Int{
    private  int  data ;          //包装一个基本数据类型
    public Int(int data)
    {
        this.data = data ;
    }
    public int intValue(){
        return this.data ;
    }
}
public class Wtest {
    public static void main(String[] args) {
        Object obj = new Int(10);          //装箱：将基本数据类型保存在包装类之中
        int temp = ((Int)obj).intValue();        //拆箱：从包装类对象中获取基本数据类型
        System.out.println(temp * 2);

        //自动装箱拆箱
        Integer x = 10 ;        //自动装箱（无构造方法）
        int num1 = x ;          //自动拆箱
        x++ ;                   //包装类对象可以直接参与数学运算
        System.out.println(x * num1);

        Object object = true;              //boolean自动装箱为Boolean，向上转型为Object
        boolean num = (Boolean) object;    //向下转型为包装类，自动拆箱
        System.out.println(num);
    }
}
