package Java三.反射.Class类对象的三种实例化模式;

class Person {
} // 自定义程序类

public class ClassDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        //1.【Object类支持】:public final native Class<?> getClass()
        // 缺点必须产生指定类对象后才可以获得
        Person person = new Person();     //已经存在类的实例化对象
        Class<? extends Person> cls1 = person.getClass();
        System.out.println(cls1.getName());  //
        // 获得类的完整名称
        //  Java三.反射.class类对象的三种实例化.Person

        //2.【JVM直接支持】采用“类.class”形式实例化
        //必须导入程序所对应的开发包
        Class<? extends Person> cls2 = Person.class;
        System.out.println(cls2.getName());

        //3.【Class类支持】
        Class<?> cls3 = Class.forName("Java三.反射.class类对象的三种实例化.Person");
        System.out.println(cls3.getName());
    }
}

