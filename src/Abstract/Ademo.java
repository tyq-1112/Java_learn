package Abstract;

abstract class AMessage{               //抽象类
    private String name ;
    private int age ;
    public AMessage(String name , int age){
        this.name = name ;
        this.age = age ;
    }
    public abstract String getConnectInfo();      //抽象方法
}

class AateMessage extends AMessage{
    public AateMessage(String name , int age){
        super(name,age);
    }
    @Override
    public String getConnectInfo(){
        return "数据连接信息....";
    }
}
public class Ademo {
    public static void main(String[] args) {
        AMessage msg = new AateMessage("小仙女",20);
        System.out.println(msg.getConnectInfo());
    }
}
