package recursion;

public class PrintSubsequence {
    public static void printSubsequence(String input, String out){
        if(input.length()==0){
            System.out.print(out+" ");
            return;
        }
        printSubsequence(input.substring(1), out+ input.charAt(0));
        printSubsequence(input.substring(1),out);

    }

    public static void main(String[] args) {
        printSubsequence("qwertyuiopasdfghjklzxcvbnm","");
    }
}
