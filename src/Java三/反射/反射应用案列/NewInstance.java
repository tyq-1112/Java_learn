package Java三.反射.反射应用案列;

class Person {
    public Person() {
        System.out.println("I am a Constructor");
    }

    @Override
    public String toString() {
        return "I am a person";
    }

    public void set() {
    }
}

public class NewInstance {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Person.class;
        Object obj = cls.getDeclaredConstructor().newInstance();    //实例化对象
        System.out.println(obj);
        //I am a Constructor
        //I am a person
    }
}
