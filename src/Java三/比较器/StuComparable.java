package Java三.比较器;

import java.util.Arrays ;

public class StuComparable {
    public static void main(String[] args) {
        String input = "张三:23:100|李四:22:100|王五:20:70" ;
                    //姓名：年龄：成绩|
        String result [] = input.split("\\|");
        Student[] students = new Student[result.length] ;
        for(int x = 0 ; x<result.length ; x++){
            String temp [] = result[x].split(":");
            students[x] = new Student(temp[0],Integer.parseInt(temp[1]),Double.parseDouble(temp[2])) ;
        }
        Arrays.sort(students);
        for(int i = 0 ; i<students.length ; i++)
        System.out.println(students[i].toString());
    }
}

class Student implements Comparable<Student>{
    private String name ;
    private int age ;
    private double grade ;

    public Student(String name , int age ,double grade) {
        this.name = name ;
        this.age = age ;
        this.grade = grade ;
    }

    @Override
    public int compareTo(Student student) {
        if(this.grade < student.grade){
            return 1 ;
        }else if(this.grade > student.grade) {
            return -1 ;
        }else return this.age - student.age ;
    }
    @Override
    public String toString() {
        return "【学生信息】姓名："+this.name + "、年龄："+this.age + "、成绩："+this.grade ;
    }
}
