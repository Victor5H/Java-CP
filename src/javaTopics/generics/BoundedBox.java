package javaTopics.generics;

// bounded type parameters
//we will bound the box to have a certain family of types only
public class BoundedBox<T extends Number> {
//    Now BoundedBox will only accept subclasses of number like Integer, Double...
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
