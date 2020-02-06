package java二.Polymorphism;

class Animal{
    public void fun(){
        System.out.println("*******我知道走路*****");
    }
}
class Ddog extends Animal{
    @Override
    public void fun(){
        System.out.println("******我知道跑******");
    }
}
class Dbird extends Animal{
    @Override
    public void fun(){
        System.out.println("*********我知道飞********");
    }
}
public class DuoTaiS {
    public static void main(String[] args) {
        //Animal msg = new Ddog() ;
        print(new Dbird());              //向上转型
        print(new Ddog());
    }
    public static void print(Animal msg){           //统一管理,可维护性
        msg.fun();
    }
}
