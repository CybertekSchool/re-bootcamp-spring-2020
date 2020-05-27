package day5_Collections;

import java.util.Stack;

public class StackEx {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.add("a");
        stack.push("b");
        stack.push("c");
        stack.push(null);
        stack.push("d");
        stack.remove(null);

        System.out.println(stack.pop());
        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack);
    }
}
