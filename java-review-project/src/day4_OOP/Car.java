package day4_OOP;

public class Car {

    static void m1(){
        System.out.println("a");
    }
    static void m2(){
        System.out.println("b");
    }
}

class Mini extends Car{

    static void m1(){
        System.out.println("c");
    }

    static void m2(){
        System.out.println("d");
    }

    public static void main(String[] args) {
        Car c = new Mini();
        c.m1(); // a
        c.m2(); // b
        Mini.m1(); // c
        Mini.m2(); // d
        ((Mini)c).m1(); // c
        ((Mini)c).m2(); // d
    }

}
