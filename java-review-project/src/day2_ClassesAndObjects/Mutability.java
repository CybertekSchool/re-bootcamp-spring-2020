package day2_ClassesAndObjects;

public class Mutability {

    public static void main(String[] args) {
        String s = "java";
        StringBuilder ss = new StringBuilder("java");
        System.out.println(s.hashCode());

        s = s + " is fun";
        System.out.println(s.hashCode());
        System.out.println(ss.hashCode());
        System.out.println(s);

        ss.append(" is fun ");
        System.out.println(ss.toString());
        System.out.println(ss.hashCode());



    }
}
