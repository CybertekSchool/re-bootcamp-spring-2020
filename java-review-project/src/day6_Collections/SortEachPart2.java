package day6_Collections;

import java.util.*;

public class SortEachPart2 {

    public static void main(String[] args) {
        String s = sortEach("DC501GCCCA098911");
        System.out.println(s);

        // dc 501 gcca
    }


    public static String sortEach(String str) {

        String word = "";
        Queue<String> q = new PriorityQueue<>();

        for(int i=0; i < str.length(); i++) {

            boolean reset = false;
            q.add("" + str.charAt(i));

            if(Character.isLetter(str.charAt(i))) {
                if(i == str.length() -1 ||!Character.isLetter(str.charAt(i+1))) {
                    reset = true;
                }
            } else {
                if(i == str.length() -1 || !Character.isDigit(str.charAt(i+1))) {
                    reset = true;
                }
            }

            if(reset) {
                word += q.toString().replace("[","").replace("]","").replace(", ","");
                q.clear();
            }


        }

        return word;
    }

}
