package day5_Collections;

import java.util.ArrayDeque;

public class ArrayDequeEx {

    public static void main(String[] args) {

        ArrayDeque<String> arrayDeque = new ArrayDeque<>();

        arrayDeque.add("d");
        arrayDeque.add("s");
        arrayDeque.add("a");
//        arrayDeque.add(null);

        System.out.println(arrayDeque);

        System.out.println(arrayDeque.peek());
        System.out.println(arrayDeque.peekLast());

        arrayDeque.addFirst("2");
        arrayDeque.addLast("a");
        System.out.println(arrayDeque);

        arrayDeque.removeLast();
        System.out.println(arrayDeque);
    }

}
