package java二.Override;

class Channel {
    public void fun(){
        System.out.println("【父类】进行资源连接");
    }
}
class DatabaseChannel extends Channel{
    @Override
    public void fun(){
        super.fun();              //子类调用父类方法
        System.out. println("【子类】进行资源连接");
    }
}
public class Demo {
    public static void main(String[] args) {
        DatabaseChannel channel = new DatabaseChannel();  //实例化子类对象，
        channel.fun();
    }
}
