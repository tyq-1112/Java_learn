package Java三.Java基础类库;
//对象克隆：对象复制，使用已有对象内容创建一个新的对象，需要使用Object类clone()方法
//不是所有的类都可以克隆，需要实现Cloneable接口
//Cloneable没有方法是一个能力标识的接口
class Member implements Cloneable{                   //实现Cloneable接口
    private  String name ;
    private  int age ;
    public Member(String name , int age){
        this.name = name ;
        this.age = age ;
    }

    @Override
    public String toString() {
        return "【"+super.toString()+"】name、"+this.name+"age、"+this.age;   //输出对象编码
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {     //调用父类的提供的clone方法
        return super.clone();
    }
}
public class clone1 {
    public static void main(String[] args)throws Exception {
        Member memberA = new Member("小白",20);
        Member memberB = (Member) memberA.clone() ;            //clone返回的是Object
        System.out.println(memberA);
        System.out.println(memberB);

    }
}
