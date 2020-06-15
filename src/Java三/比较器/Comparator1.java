package Java三.比较器;

/**
 * Comparator 主要解决一些没有使用comparable排序的类的对象
 */
import java.util.Arrays;
import java.util.Comparator;

class People {                              //原先类没有考虑到排序的操作
    private String name ;
    private int age ;
    public People(String name ,int age){
        this.name = name ;
        this.age = age ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString(){
        return "【Person类信息：】姓名：" + this.name + "、年龄：" +this.age +"\n";
    }
}
class PeopleComparator implements Comparator<People>{            //挽救

    @Override
    public int compare(People o1, People o2) {
        return o1.getAge() - o2.getAge() ;
    }
}
public class Comparator1 {
    public static void main(String[] args) {
        People people[] = new People[]{
                new People("长沙-A", 19),
                new People("长沙-B", 29),
                new People("长沙-C", 19)
        };
        Arrays.sort(people, new PeopleComparator());          //进行对象数组排序
        System.out.println(Arrays.toString(people));
    }
}

/*中文姓名排序
* @Override
        public int compare(Student p1, Student p2) {
            String one = p1.getSname();
            String two = p2.getSname();
            Collator ca = Collator.getInstance(Locale.CHINA);
            int flags = 0;
            if (ca.compare(one, two) < 0) {
                flags = -1;
            } else if (ca.compare(one, two) > 0) {
                flags = 1;
            } else {
                flags = 0;
            }
            return flags;
        }*/
