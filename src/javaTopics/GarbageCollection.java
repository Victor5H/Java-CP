package javaTopics;

import javaTopics.comparator.Student;

import java.lang.ref.WeakReference;

public class GarbageCollection {
    public static void main(String[] args) {
        Student s = new Student("Harshit",5.4);
        WeakReference<Student> weak =
                new WeakReference<>(new Student("Yash",1.4));
        System.out.println(s);
        System.out.println(weak.get());
        System.gc();
        try {
            System.out.println("Waiting...");
            Thread.sleep(10000);
        }catch (Exception ignore){}
        System.out.println(s);
        System.out.println(weak.get());
    }
}
