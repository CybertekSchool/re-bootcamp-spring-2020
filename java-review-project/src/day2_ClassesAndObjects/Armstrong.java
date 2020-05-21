package day2_ClassesAndObjects;

        /*
        Task 2:
        Create a method that will accept a number and check if the number is an Armstrong number.
        If the number is an Armstrong number return true otherwise return false.

         */

public class Armstrong {

    // 153 > 1^3 + 5^3 + 3^3 == 153
    // 1^3 = 1 * 1 * 1
    // 5^3 = 5 * 5 * 5

    public static void main(String[] args) {
        System.out.println(isArmstrong(4210818));
    }

    public static boolean isArmstrong(int num) {

        String number = String.valueOf(num);
        int power = number.length();
        int sum = 0;

        for(int i=0; i < number.length(); i++) {

            int digit = Integer.parseInt(""+ number.charAt(i));
            sum += Math.pow(digit, power);

        }

        return sum == num;

    }

    public static boolean isArmstrong2(int num) {

        int digits = num;
        int sum = 0;
        int power = String.valueOf(num).length();

        // 1
        // num % 10 --> last digit

        while(digits != 0){

            int each = digits % 10;
            digits /= 10;

            sum += Math.pow(each, power);
        }
        return sum == num;
    }

}
