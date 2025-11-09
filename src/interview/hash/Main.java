package interview.hash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        HashSet<User> user = new HashSet<>();
        user.add(new User("zrshit@gmail.com","Harshit",123));
        user.add(new User("marshit@gmail.com","Harshit",123));
        user.add(new User("parshit@gmail.com","Harshit",123));
        user.add(new User("harshit@gmail.com","Harshit",123));
        user.add(new User("harshit@gmail.com","Harshit",123));
//        System.out.println(user);
        System.out.println(user);
    }
}
