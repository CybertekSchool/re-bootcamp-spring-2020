package day5_Collections;

public class ExceptionEx {
    public static void main(String[] args) {
        try {
            String s = "java";

            System.out.println(s.substring(1));
            System.out.println(4/4);

        } catch (StringIndexOutOfBoundsException e) {
            System.out.println(e);
        } catch (ArithmeticException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }finally {
            System.out.println("finally block");
        }
        }


}
