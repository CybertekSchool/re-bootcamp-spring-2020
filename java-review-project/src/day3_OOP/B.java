package day3_OOP;

public class B extends A{

    int num = 20;
//    public final void method2(){
//
//    }

    @Override
    public String get(){
        System.out.println("B");
        return "";
    }

    public void m3() {
        System.out.println("From m3: ");
        System.out.println(super.num);
    }


    static void method1(){
        System.out.println("Coming from B class");
    }

}
