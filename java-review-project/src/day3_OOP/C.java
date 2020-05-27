package day3_OOP;

public class C {
    public static void main(String[] args) {

        A.method1();
        B.method1();

        B b = new B();
        b.get();

        System.out.println(b.num);
        b.m3();

    }
}
