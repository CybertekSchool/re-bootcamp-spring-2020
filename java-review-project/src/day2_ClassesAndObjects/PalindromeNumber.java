package day2_ClassesAndObjects;


        /*
        Task 3: Create a method that will accept a number (long)
         and determine if the number of palindrome or not.
         */

import java.util.stream.DoubleStream;

public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(isPalindrome(1203022));
    }

    public static boolean isPalindrome(long num){

        long remain = num; //
        long rev = 0;  // 1203021

        while(remain != 0) {

            long digit = remain % 10; // 2

            rev = rev * 10 + digit; // 0 * 10 -> 0 + 1

            remain /= 10;

        }

        return num == rev;

    }









}
