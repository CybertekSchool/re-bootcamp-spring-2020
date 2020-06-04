package day2_ClassesAndObjects;

public class Example {
    public static void main(String[] args) {
        new Example(7,4);
    }

    public Example() {
        System.out.println("no param");
    }

    public Example (int a) {

        System.out.println(a);
    }

    public Example(int a, int b){
        this(a);
        System.out.println(b);

    }


}
