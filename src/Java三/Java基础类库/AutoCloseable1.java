package Java三.Java基础类库;

//AutoCloseable：实现资源的自动关闭(释放资源)，文件、网络、数据库

interface IMessage extends AutoCloseable{     //继承AutoCloseable
    public abstract String send();
}
class Message implements IMessage {
    private String msg ;
    public Message(String msg){
        this.msg = msg ;
    }
    public String send(){
        return "发送消息内容："+this.msg ;
    }
    @Override
    public void close(){
        System.out.println("消息发送完成，可进行关闭");
    }

}
public class AutoCloseable1 {
    public static void main(String[] args) {
        //要使用AutoCloseable之外，还需要结核异常处理语句才可，
        try(IMessage msg = new Message("武汉加油，中国加油")){
            System.out.println(msg.send());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
