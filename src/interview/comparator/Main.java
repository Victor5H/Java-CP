package interview.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> user = new ArrayList<>();
        user.add(new User("zrshit@gmail.com","Harshit",123));
        user.add(new User("marshit@gmail.com","Harshit",123));
        user.add(new User("parshit@gmail.com","Harshit",123));
        user.add(new User("harshit@gmail.com","Harshit",123));
        user.add(new User("aarshit@gmail.com","Harshit",123));
        System.out.println(user);
        user.sort((a,b)->a.getEmail().compareTo(b.getEmail()));
        System.out.println(user);
    }
}
