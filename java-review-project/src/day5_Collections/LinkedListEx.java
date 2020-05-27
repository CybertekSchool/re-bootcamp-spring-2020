package day5_Collections;

import java.util.LinkedList;
import java.util.List;

public class LinkedListEx {
    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.addFirst("z");
        list.addLast(null);
        System.out.println(list);

    }
}
