package java二.Polymorphism;

class Dperson{
    public void function(){
        System.out.println("*********一个人具有的基本功能：吃饭、睡觉、打豆豆*********");
    }
}
class Dsuperman extends Dperson{
    public String fire(){
        return "*****我能够喷火*****";
    }
}
public class DuoTaiX {
    public static void main(String[] args) {
        System.out.println("************舒适的地球生活中************");
        Dperson msg = new Dsuperman();                                     //向上转型
        msg.function();
        System.out. println("*************外星人攻打地球时***********");
        if(msg instanceof Dsuperman){                                    //判断后转型
            Dsuperman superman = (Dsuperman) msg ;                             //需要子类的功能时，向下转型
            System.out.println(superman.fire());
        }
        //在向下转型之前一定要先向上转型
        //如果两个没有任何关系的实例发生强制转型，就会出现异常
    }
}
