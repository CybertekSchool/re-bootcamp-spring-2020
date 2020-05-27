package day4_OOP;

public class C extends B implements Extra{

    @Override
    public void m() {
        System.out.println("C");
    }

    @Override
    public void m2() {
        System.out.println("Extra");
    }
}
