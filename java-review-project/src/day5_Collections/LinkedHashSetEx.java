package day5_Collections;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class LinkedHashSetEx {
    public static void main(String[] args) {
        LinkedHashSet<String> set = new LinkedHashSet<>();
        set.add("z");
        set.add("y");
        set.add(null);
        set.add("z");
        set.add("80");
        set.add("/");
        set.add(null);
        set.add("z");
        set.add("a");

        System.out.println(set);
    }
}
