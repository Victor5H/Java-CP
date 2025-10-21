package daily.twentythOct;
//https://leetcode.com/problems/length-of-last-word/
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int i=s.length()-1;
        while(i>=0 && s.charAt(i)==' '){
            i--;
        }
        int count=0;
        while(i>=0 && s.charAt(i)!=' '){
            i--;
            count++;
        }
        return count;
    }
}
