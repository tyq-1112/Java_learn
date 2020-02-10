package Java三.集合工具类;

import java.util.Stack;

public class Stack1 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("123");
        stack.push("456");
        stack.push("789");

        while(!stack.empty()){
            System.out.println(stack.pop());
        }
    }
}
