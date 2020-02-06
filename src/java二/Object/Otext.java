package java二.Object;

class Operson{
    private String name ;
    private  int age ;
    public Operson(String name , int age )
    {
        this.name = name ;
        this.age = age ;
    }
    @Override
    public String toString ()     //覆写父类（object）中的toString方法
    {
        return "姓名："+ this.name +"\n年龄："+this.age ;
    }
    @Override
    public boolean equals(Object obj){             //覆写父类中的equals方法
        if(obj instanceof  Operson)               //同类进行比较
        {
            if(obj == null)return false ;
            if(this == obj )return true ;                //同一个地址
            Operson per = (Operson)obj ;
            return this.name.equals(per.name) && this.age == per.age ;
        }
        return false ;
    }
}
public class Otext {
    public static void main(String[] args) {
        Object msg1 = new Operson("小仙女",20) ;
        Object msg2 = new Operson("小仙女",20);

        if(msg1 instanceof Operson){
            Operson person = (Operson) msg1 ;
            System.out.println("Operson对象向下转型执行完毕 ");
        }

        //System.out.println(msg1);
        System.out.println(msg1.toString());
        //Object中toString()方法，和直接输出msg一样，获得对象信息

        System.out.println(msg1.equals(msg2));              //对象比较
    }
}
