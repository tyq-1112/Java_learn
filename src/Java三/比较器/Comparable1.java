package Java三.比较器;
import java.util.Arrays ;
//自定义对象排序

class Person implements Comparable<Person>{
    private String name ;
    private int age ;
    public Person(String name ,int age){
        this.name = name ;
        this.age = age ;
    }
    public String toString(){
        return "【Person类信息：】姓名：" + this.name + "、年龄：" +this.age +"\n";
    }

    @Override
    public int compareTo(Person pre) {
        return this.age - pre.age ;
    }
}
public class Comparable1 {
    public static void main(String[] args) {
        Person person[] = new Person[]{
                new Person("长沙-A",19),
                new Person("长沙-B",29),
                new Person("长沙-C",19)
        };
        Arrays.sort(person) ;          //进行对象数组排序
        System.out.println(Arrays.toString(person));
    }
}
