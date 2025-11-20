package javaTopics.exception;

public class CallStackDemo {
    public static void main(String[] args) {
        try {
            l1();

        }catch (RuntimeException e){
            System.out.println(e);
        }
    }
    public static void l1(){l2();}
    public static void l2(){l3();}
    public static void l3(){
        throw new RuntimeException("hehe boi");
    }
}
