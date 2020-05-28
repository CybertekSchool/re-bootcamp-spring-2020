package day6_Collections;

    /*
    Create a method that will accept a String and returns
    a version that removes duplicate instances of any character
    Ex: removeDup("AAABBBCCCD") ==> ABCD
     */

import java.util.Arrays;
import java.util.LinkedHashSet;

public class RemoveDuplicates {

    public static void main(String[] args) {
        System.out.println(removeDupValues("AAABBBCCCDEEEKKEEELL"));
    }


    public static String removeDupValues(String str) {

        String [] arr = str.split("");
        LinkedHashSet<String> set = new LinkedHashSet<>(Arrays.asList(arr));
        return set.toString().replace("[","").replace("]","").replace(", ","");
    }


}
