package java二.Interface;

interface IMessage{                            //定义一个接口
     String INFO = "www.github.com" ;        //全局常量
     String getInfo() ;                            //抽象方法
}
interface IChannel{
     boolean connect() ;
}
class MessageImp  implements IMessage,IChannel{                       //实现接口
    public String getInfo(){
        return "得到一个好消息，除夕快乐...." ;
    }
    public boolean connect(){
        System.out.println("————消息通道以成功建立————");
        return true ;
    }
}
public class IDemo {
    public static void main(String[] args) {
        IMessage msg = new MessageImp() ;
        //System.out.println(msg.getInfo() + IMessage.INFO);
        if(msg instanceof IChannel){
            //由于MessgaeImp子类实现了两个接口，所有这个子类是两个接口的实例，表示这两个接口实例之间可以相互转换
            IChannel chl = (IChannel)msg ;
            System.out.println(chl.connect());

            //Object与接口转换
            Object obj = msg ;      //向上转型
            IChannel chal = (IChannel)obj ;
            System.out.println(chal.connect());
        }
    }
}
