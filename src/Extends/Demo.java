package Extends;

class People {                    //父类
    private String name ;
    private  int age ;
    public People(String name , int age ) {
        this.name = name ;
        this.age = age ;
        System.out.println("People父类构造方法");
    }
}
class Student extends People{             //子类
    private String school ;
    public Student(String name , int age , String school) {
        super(name,age);               //调用父类构造
        this.school = school ;
        System.out.println("Student子类构造方法");
    }
}

public class Demo {
    public static void main(String[] args) {
        new Student("小仙女",20,"清华大学");
        //实例化子类对象的同时一定会实例化父类对象
        //super 与 this 都是调用构造方法，两个语句不能同时出现
    }
}
