package java二.Definition_of_Array;

class Demo
{
    public static int sum(int ... data) {
        int sum = 0;
        for (int i : data)
            sum = sum + i;
        return sum;
    }
}
public class Variable {
    public static void main(String[] args) {
        System.out.println(Demo.sum(1,2,3,4,5));
        System.out.println(Demo.sum(new int [] {1,2,4,5,3,4}));
    }
}
