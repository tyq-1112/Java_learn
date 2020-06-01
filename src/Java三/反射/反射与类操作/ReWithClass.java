package Java三.反射.反射与类操作;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

interface IMessage {
    void send();
}

interface IChannel {
    boolean connect();
}

public class ReWithClass {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Person.class;  //获取指定类的Class对象

        //反射调用类中的方法  public Object invoke(Object obj , Object...args)
        String attribute = "name";    //要操作的类属性
        String value = "小强子";     //要设置的属性内容
        //1.反射实例化
        Object obj = cls.getDeclaredConstructor().newInstance();  //实例化对象（分配成员空间）
        //2.获取需调用的方法
        Method setmethod = cls.getDeclaredMethod("setName", String.class);
        setmethod.invoke(obj, value);    //等价于Person对象.setName(value);

        Method getmethos = cls.getDeclaredMethod("getName");
        System.out.println(getmethos.invoke(obj));   //等价于Person对象.getName()

        //反射调用成员
        /*在Field类里：设置属性内容：public void set(Object obj , Object value);
                       获取属性内容：public void get(Object obj)
                       解除封装：public void setAccessible(boolean flag)
                       (最常用)获取成员类型： public Class<?> getType()
         */

        //获取私有name属性
        Field nameFile = cls.getDeclaredField("name");
        nameFile.setAccessible(true);
        nameFile.set(obj, "反射");
        System.out.println(nameFile.get(obj));
        //获取name属性的类型
        System.out.println(nameFile.getType().getSimpleName());

    }
}

class Person extends abstractBase implements IMessage, IChannel {
    private String name;
    private int age;

    public Person() {
    }  //无参构造

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void send() {
        if (this.connect()) System.out.println("消息发送成功.....");
    }

    @Override
    public boolean connect() {
        return true;
    }
}

abstract class abstractBase {
    public static final String Base = "www.baidu.com";
    private String info = "Hello Demo";

    public abstractBase() {
    }

    public abstractBase(String name, int age) {
    }
}
