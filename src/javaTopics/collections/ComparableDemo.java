package javaTopics.collections;

import java.util.ArrayList;
import java.util.List;

class Person implements Comparable<Person> {
    private String name;
    private int id;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.getName());
    }
}

public class ComparableDemo {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Harshit",4));
        list.add(new Person("Aditya",4));
        list.add(new Person("Yash",5));
        System.out.println(list);
        list.sort(null);
        System.out.println(list);
    }

}
