package javaTopics.lambda;

//this should only contain 1 abstract method else it will not be qualified as a Functional Interface
@FunctionalInterface
public interface FilteringCondition {
    static void some(){
        System.out.println("something");
    }
    default void some1(){
        System.out.println("something2");
        some2();
    }
    private void some2(){
        System.out.println("sdfsdf");
    }
    boolean filter(Hotel hotel);
}
