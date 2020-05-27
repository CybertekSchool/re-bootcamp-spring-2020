package day5_Collections;

import java.util.HashSet;
import java.util.Set;

public class HashSetEx {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
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
