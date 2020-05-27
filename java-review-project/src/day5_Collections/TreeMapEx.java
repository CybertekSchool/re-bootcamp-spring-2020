package day5_Collections;

import java.util.LinkedHashMap;
import java.util.TreeMap;

public class TreeMapEx {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();

        map.put(3, "three");
        map.put(4, "four");
       // map.put(null, "this null");
        map.put(2, "two");
        map.put(1, "one");

        System.out.println(map);
    }
}
