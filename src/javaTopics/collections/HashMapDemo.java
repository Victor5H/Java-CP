package javaTopics.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
class Student{
    private String name;
    private int roll;

    public Student(String name, int roll) {
        this.name = name;
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roll,name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", roll=" + roll +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if(obj==null||getClass() != obj.getClass()) return false;
        Student o = (Student) obj;
        return roll==o.getRoll()&& Objects.equals(getName(),o.getName());
    }
}
public class HashMapDemo {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"Harshit");
        map.put(5,"Ekansh");
        map.put(3,"Yash");
        System.out.println(map.getOrDefault(1,"none"));
//        this will not update existing value,
        map.putIfAbsent(5,"Harshit");
        map.putIfAbsent(6,"Yo yo");
        System.out.println(map);

        System.out.println(map.get(5));
        System.out.println(map.get(7));

        System.out.println(map.containsKey(4));
        System.out.println(map.containsValue("Harshit"));

//        looping over map
        for (int k: map.keySet()){
            System.out.println(map.get(k));
        }
//        iterating over entry
        Set<Map.Entry<Integer,String>> entries = map.entrySet();
        for (Map.Entry<Integer,String> e: entries){
            System.out.println("Key "+e.getKey());
            e.setValue(e.getValue().toUpperCase());
            System.out.println("Value: "+e.getValue());
        }
        Map<Student,Integer> grades = new HashMap<>();
        grades.put(new Student("Alice",1),5);
        grades.put(new Student("Alice",1),6);
        grades.put(new Student("Bob",2),5);
        System.out.println(grades.get(new Student("Alice",1)));
        System.out.println(grades);
        System.out.println(grades.size());
    }
}
