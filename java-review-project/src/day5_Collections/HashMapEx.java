package day5_Collections;

import java.util.HashMap;

public class HashMapEx {
    public static void main(String[] args) {

        HashMap<Integer, String> map = new HashMap<>();

        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(2, "null");
        map.put(null, "null");

        System.out.println(map);


    }
}
