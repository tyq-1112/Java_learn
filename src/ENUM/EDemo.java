package ENUM;

interface IColor{
    public String Isend();
}
enum Color implements IColor{               //枚举类
    RED("红色"), GREEN("绿色"), BLUE("蓝色");       //实例化对象，要写在首行
    private String title ;
    private Color(String title){
        this.title = title ;
    }
    public String toString(){
        return this.title ;
    }
    @Override
    public String Isend(){
        return "枚举类也可以实现接口哦！" ;
    }
}

public class EDemo {
    public static void main(String[] args) {
        Color C = Color.BLUE;                  //获取实例化对象
        System.out.println(C);
        System.out.println(C.ordinal());        //获得对象序列
        System.out.println(C.name());           //获得对象名字

        for (Color c:Color.values()           //获取所有枚举对象
             ) {
            System.out.println(c.toString());
        }
        IColor color = Color.BLUE ;
        System.out.println(color.toString());
    }
}
