package Java三.反射.反射应用案列;

interface IMessage {
    void send();
}

interface IService {
    void service();
}

public class ReWithFactory {
    public static void main(String[] args) throws Exception {
        IMessage msg = Factoy.getInstance("Java三.反射.反射应用案列.NetMessage", IMessage.class);
        msg.send();
        IService service = Factoy.getInstance("Java三.反射.反射应用案列.HouseService", IService.class);
        service.service();
    }
}

class Factoy {
    private Factoy() {
    }

    public static <T> T getInstance(String className, Class<T> tClass) throws Exception {
        T instance = null;
        instance = (T) Class.forName(className).getDeclaredConstructor().newInstance();
        return instance;
    }
}

class NetMessage implements IMessage {
    @Override
    public void send() {
        System.out.println("网络信息发送");
    }
}

class HouseService implements IService {
    @Override
    public void service() {
        System.out.println("住房服务");
    }
}
