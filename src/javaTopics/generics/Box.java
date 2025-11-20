package javaTopics.generics;

//by using <P> box is now generic type
public class Box <P>{
    private P value;

    public P getValue() {
        return value;
    }

    public void setValue(P value) {
        this.value = value;
    }
}
