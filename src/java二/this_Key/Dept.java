package java二.this_Key;

class Student
{
    private String name ;
    private int age ;
    private String xuehao ;
    public Student(){

    }
    public Student(String name ,int age , String xuehao)
    {
        this.name = name ;
        this.age = age ;
        this.xuehao = xuehao ;
    }
    public  String getInfo()
    {
        return "姓名："+this.name + "\n学号："+this.xuehao + "\n年龄："+this.age ;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public  void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setXuehao(String xuehao) {
        this.xuehao = xuehao;
    }

    public String getXuehao() {
        return xuehao;
    }
}

public class Dept {
    public static void main(String[] args) {
         Student student = new Student("小仙女",20,"180707");
        System.out.println(student.getInfo());
    }
}
