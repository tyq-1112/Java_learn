package Java三.开发支持类库;
//Optional类的主要功能 进行null的处理
import java.util.Optional;

interface IMessage{
    String getContent() ;
}

class MessageImpl implements  IMessage{

    @Override
    public String getContent() {
        return "灰太狼爱上了小红狼";
    }
}

class MessageUtil{
    private MessageUtil(){}
    public static Optional<IMessage> getMessage(){
        return Optional.of(new MessageImpl()) ;                //of方法，不可以为null
        // return Optional.ofNullable(null) ;        //可以为null
    }

    public static void uesMessage(IMessage msg){
        System.out.println(msg.getContent()) ;
    }
}
public class Optional1 {
    public static void main(String[] args) {
        IMessage iMessage =  MessageUtil.getMessage().get() ;      //获取数据
        //如果为空 ，使用orElse方法
        MessageUtil.uesMessage(iMessage);
    }
}
