package daily.sixteenApril;

public class Palindrome {
    public static boolean isPalindrome(String input){
        if(input.length()==1) return true;
        if (input.charAt(0)!=input.charAt(input.length()-1)) return false;
        return isPalindrome(input.substring(1,input.length()-1));
    }
    public static boolean isPalindromeI(String input){
        int first=0,last=input.length()-1;
        while (first<last){
            if(input.charAt(first)==input.charAt(last)){first++;last--;}
            else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromeI("harshit"));
    }
}
