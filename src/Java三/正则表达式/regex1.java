package Java三.正则表达式;

public class regex1 {
    public static void main(String[] args) {
        String str = "abc" ;
        String regex = "\\w{3,}" ;
        System.out.println(str.matches(regex));
    }
}
