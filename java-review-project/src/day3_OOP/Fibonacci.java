package day3_OOP;

    /*
    Task 4: (from Day 2)
    Create a method that will accept a that will accept
    a number (int) and print that many Fibonacci numbers

     */

public class Fibonacci {

    public static void main(String[] args) {
        Fibonacci(15);
    }

    public static void Fibonacci(int num) {

        int a = 0;
        int b = 1;
        System.out.print(a + " " + b);

        for(int i=2; i < num; i++) {

            int next = a + b;
            a = b;
            b = next;
            System.out.print(" " + next);

        }

    }


}
