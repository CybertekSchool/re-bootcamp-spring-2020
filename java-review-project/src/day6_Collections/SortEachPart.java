package day6_Collections;


    /*
    Create a method that will take any String of letters
    and numbers and sort each substring of numbers and letters
     */

import java.util.Arrays;

public class SortEachPart {

    /*
    Input: "DC501GCCCA098911"
    OutPut: "CD015ACCCG011899"
     */

    public static void main(String[] args) {
        System.out.println(sortEach("DC501GCCCA098911"));
    }

    public static String sortEach(String str) {
        //DC501
        String sorted = ""; // where the final result is stored
        String each = ""; // where the substring of each part (digit/letter)

        for(int i=0; i < str.length(); i++) { // loops through the whole String

            each += str.charAt(i); // always adds the character by the index
                                    // that were are at (i) to the each String

            if(Character.isLetter(str.charAt(i))){
            // if we are in here the char is a letter
                // Next we check for if the next char is also a letter
                // If the next char is a letter, then everything is okay
                // if the next char is not a letter, we need to take the each
                // substring and sort it

                // i == str.length()-1   -> when we get to the last index, we forcing
                // the substring part each to be sorted

                if(i == str.length()-1 || !Character.isLetter(str.charAt(i+1))){
                    sorted += sortSubstring(each); // break the each String and sort
                                                    // the characters
                    each = "";  // reset each for the digits
                }

            } else {  // if we are here, the char we are looking is a digit
                // checks if the next char is not a digit, if not then it
                // does the same as above and sort the digits substring of each
               if(i == str.length()-1 || !Character.isDigit(str.charAt(i+1))) {
                   sorted += sortSubstring(each);
                   each = ""; // reset each to get ready for the letter
               }

            }

        }


        return sorted;
    }

    private static String sortSubstring(String str) {

        String [] arr = str.split("");
        Arrays.sort(arr);
        return Arrays.toString(arr).replace("[", "")
                .replace("]","").replace(", ", "");

    }




}
