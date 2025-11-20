package javaTopics.exception;

public class FinallyDemo {
    public static void main(String[] args) {
        System.out.println(divide(56,4));
        System.out.println(divide(56,0));
    }
    public static double divide( double a, double b){
        try {
            return a/b;
        }catch (ArithmeticException e){
            return -1;
        }
        finally {
            System.out.println("finally");
        }
    }
}
