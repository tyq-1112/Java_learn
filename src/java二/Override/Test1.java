package java二.Override;

class Channel1{
    private void connect() {                          //private修饰
        System.out.println("【父类】进行资源连接");
    }
    public void fun(){
        this.connect();
    }
}
class DataChannel extends Channel1{

    //此时并不是一个覆写，因为父类的connect方法不可见，那么这个方法对于子类而言就相当于新定义的方法

    public void connect() {                          //public修饰
        System.out.println("【子类进行资源连接】");
    }
}
public class Test1 {
    public static void main(String[] args) {
        DataChannel channel1 = new DataChannel();
        channel1.fun();
    }
}
