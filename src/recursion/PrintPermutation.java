package recursion;

public class PrintPermutation {
    public static void printPermutation(String ques, String ans){
        if(ques.isEmpty()){
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < ques.length(); i++) {
            char curr = ques.charAt(i);
            String leftPart = ques.substring(0,i);
            String rightPart = ques.substring(i+1);
            printPermutation(leftPart+rightPart,ans+curr);
        }
    }

    public static void main(String[] args) {
        printPermutation("har","");

    }
}
