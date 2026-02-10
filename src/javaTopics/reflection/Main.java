package javaTopics.reflection;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c = TP.class;
        System.out.println(Arrays.toString(c.getDeclaredFields()));
        System.out.println(Arrays.toString(c.getFields()));
//        System.out.println(Arrays.toString(c.getSigners()));
        System.out.println(Arrays.toString(c.getClasses()));
        System.out.println(Arrays.toString(c.getMethods()));
        System.out.println(Arrays.toString(c.getDeclaredConstructors()));
        System.out.println(c.getClassLoader());
    }
}
