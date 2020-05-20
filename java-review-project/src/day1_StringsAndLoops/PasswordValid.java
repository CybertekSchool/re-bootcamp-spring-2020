package day1_StringsAndLoops;

public class PasswordValid {

    public static void main(String[] args) {

        String password = "a?G6jdsaja";

        boolean length = password.length() >= 8;
        boolean lower = password.matches(".*[a-z].*");
        boolean upper = password.matches(".*[A-Z].*");
        boolean number = password.matches(".*[0-9].*");
        boolean special = password.matches(".*[!@.,#$?].*");

        boolean valid = length && lower && upper && number && special;

        if(valid) {
            System.out.println("Password is valid");
        } else {
            System.out.println("Not a valid password");
        }


    }


}
