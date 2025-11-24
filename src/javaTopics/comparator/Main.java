package javaTopics.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    static class IntegerReverseComp implements Comparator<Integer>{
        @Override
        public int compare(Integer i1, Integer i2) {
//            +ve i1 after i2
//            0 means i1=i2
//            -ve i1 before i2
            return i2-i1;
        }
    }
    static class StringLengthComp implements Comparator<String>{
        @Override
        public int compare(String s1, String s2) {
            return s1.length()-s2.length();
        }
    }
    public static void main(String[] args) {
        List<String> strs = new ArrayList<>(List.of("Apple","Orange","orange","banana","one","tw","safjkjhjsad"));
        strs.sort(new StringLengthComp());
        System.out.println(strs);
        List<Integer> nums = new ArrayList<>(List.of(1,4,32,6,25,52,45,7,223,6,84,34,63,7,3));
        nums.sort((a,b)->b-a);//reverse ordering
        System.out.println(nums);

        List<Student> students = new ArrayList<>();
        students.add(new Student("Harshit",4.5));
        students.add(new Student("Shubham",4.2));
        students.add(new Student("Bob",2.4));
        students.add(new Student("Alice",2.4));
        students.add(new Student("Yash",4.3));
        System.out.println(students);
        students.sort((a,b)->(int) (b.getGpa()-a.getGpa()));// converting it into int will
//        create a bug, gpa with 4.3 and 4.3 will be considered the same
//        to avoid this use following
        students.sort((a,b)->{
           if(a.getGpa()-b.getGpa()<0) return 1;
           if(a.getGpa()- b.getGpa()>0)return -1;
           else return a.getName().compareTo(b.getName());
        });
        System.out.println(students);

//        we can also use a static method of Comparator class called comparing
        Comparator<Student> gpcComp = Comparator.comparing(Student::getGpa);
        Comparator<Student> gpcCompR = Comparator.comparing(Student::getGpa).reversed();
        Comparator<Student> gpcCompRS = Comparator.comparing(Student::getGpa).reversed().thenComparing(Student::getName);
        students.sort(gpcComp);

    }
}
