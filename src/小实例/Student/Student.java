package 小实例.Student;

public class Student implements Comparable<Student> {
    private String name;
    private double socre;

    public Student(String name, double socre) {
        this.name = name;
        this.socre = socre;
    }

    public String getName() {
        return name;
    }

    public double getSocre() {
        return socre;
    }

    @Override
    public int compareTo(Student obj) {
        if (obj.socre > this.socre) return 1;
        else if (obj.socre < this.socre) return -1;
        else return 0;
    }

    public String toString() {
        return "姓名：" + this.name + " 分数：" + this.socre + "\n";
    }
}
