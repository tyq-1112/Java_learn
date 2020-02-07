package java二.Genericty;
//泛型接口

interface IMessage<T>{
     String echo(T s);
}

class Message<T> implements IMessage<T>{
    //class Message implements IMessage<String>
    @Override
    public String echo(T s){
        return ""+s;
    }
}
public class GIDemo {
    public static void main (String[] args) {
        IMessage<String> message = new Message<String>();
        //IMessage<String> message = new Message();
        System.out.println(message.echo("www.baidu.com"));
    }
}
