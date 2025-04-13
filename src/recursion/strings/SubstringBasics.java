package recursion.strings;

public class SubstringBasics {
    public static void main(String[] args) {
        String str = "Harshit";
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
        }
        String sub = str.substring(3);
        System.out.println(sub);
        sub = str.substring(3,5); // last index is exclusive
        System.out.println(sub);
    }
}
