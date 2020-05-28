package day6_Collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortEachPart2 {

    public static void main(String[] args) {
        System.out.println(sortEach("DC501GCCCA098911"));

        // dc 501 gcca
    }


    public static String sortEach(String str) {

        List<Set<String>> each = new ArrayList<>();
        Set<String> set = new TreeSet<>();

        for(int i=0; i < str.length(); i++) {
            char c = str.charAt(i);
            boolean reset = false;
            set.add("" + c);

            if(Character.isLetter(c)) {
                if(i == str.length() -1 ||!Character.isLetter(str.charAt(i+1))) {
                    reset = true;
                }
            } else {
                if(i == str.length() -1 || !Character.isDigit(str.charAt(i+1))) {
                    reset = true;
                }
            }

            if(reset) {
                each.add(set);
                set.clear();
            }

        }

        System.out.println(each);
        return "";
    }

}
