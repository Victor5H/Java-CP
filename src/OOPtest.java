import java.util.HashMap;

class Person{
    int age;
    String name;
    public void sayhi(){
        System.out.println("["+name+" - " +age+"]");
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Person() {
    }
}
public class OOPtest {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.age=10;
        p1.name="a";
        p1.sayhi();
        Person p2 = new Person(20,"b");
        p2.sayhi();

    }
}
