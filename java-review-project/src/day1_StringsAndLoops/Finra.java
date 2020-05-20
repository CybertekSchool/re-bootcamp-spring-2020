package day1_StringsAndLoops;

public class Finra {

    public static void main(String[] args) {

        for(int i=1; i <= 30; i++) {

           String print = "";

           if(i % 3 == 0) print = "FIN";

           if(i % 5 == 0) print += "RA";

           if(print.isEmpty()){
               System.out.println(i);
           } else {
               System.out.println(print);
           }


        }



    }

}
