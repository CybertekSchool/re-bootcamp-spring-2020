package day1_StringsAndLoops;

public class CountJava {
    public static void main(String[] args) {
        String str = "java is fun. java is the best";
        int java = 0;
        // approach one

        for(int i=0; i < str.length()-3; i++) {

            if(str.substring(i, i+4).equalsIgnoreCase("java")) java++;

        }

        System.out.println("Java was found: " + java);

        // approach two

        int java2 = 0;
        str = str.toLowerCase();
        while(str.contains("java")) {

            java2++;

            str = str.replaceFirst("java","");

        }

        System.out.println("Java 2 " + java2);

    }
}
