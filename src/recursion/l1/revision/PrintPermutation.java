package recursion.l1.revision;

public class PrintPermutation {
    public static void levelOrder(String input, String ansSF){
        if(input.isEmpty()){ System.out.println(ansSF);return;}
        for (int i = 0; i < input.length() ; i++) {
            levelOrder(input.substring(0,i)+input.substring(i+1),ansSF+input.charAt(i));
        }
    }

    public static void main(String[] args) {
        levelOrder("abc","");
    }
}
