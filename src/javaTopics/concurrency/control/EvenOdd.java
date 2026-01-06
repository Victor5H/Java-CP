package javaTopics.concurrency.control;

public class EvenOdd {
    public static void main(String[] args) {
        Runnable zero = ()-> System.out.print("0");
        Runnable odd = ()-> System.out.print("0");
        Runnable one = ()-> System.out.print("0");
        Thread t = new Thread();
    }
}
