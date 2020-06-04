package day4_OOP;

public class PloyTest {
    public static void main(String[] args) {

        A a = new C();
        B b = new C();
        C c = new C();
        Extra e = new C();

        c.m();
        b.m();
        a.m();
        System.out.println();
        System.out.println(c.s);
        System.out.println(b.s);
     //   System.out.println(a.s);

        e.m2();
        c.m2();
      //  b.m2();

        B b2 = c;
        C c2 = (C)b;
    }
}
