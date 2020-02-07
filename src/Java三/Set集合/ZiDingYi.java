package Java三.Set集合;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Person {
    private String name;
    private int age;

    //工具自动生成
    @Override
    public int hashCode() {
        return Objects.hash(name,age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "姓名：" + this.name + "   年龄：" + this.age;
    }

}

public class ZiDingYi {
    public static void main(String[] args) {
        Set<Person> people = new HashSet<>();
        people.add(new Person("小红", 19));
        people.add(new Person("小红", 19));
        people.add(new Person("小白", 20));
        people.add(new Person("小白", 19));
        people.forEach(System.out::println);
        /*
        姓名：小白   年龄：20
        姓名：小白   年龄：19
        姓名：小红   年龄：19
        * */
    }
}
