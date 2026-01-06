package daily.TwentyFive.sixteenthOct;
//https://leetcode.com/problems/plus-one/
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int[] ret = new int[digits.length];
        int carry=0;
        for(int i=ret.length-1;i>=0;i--){
            int sum=0;
            if(i==digits.length-1) {
                sum = digits[i]+1;
            }
            else{
                sum = digits[i]+carry;
                carry=0;
            }
            if(sum>9){
                int rem = sum%10;
                carry=(sum/10);
                sum = rem;
            }
            ret[i] = sum;
        }
        if(carry!=0){
            int []n = new int[ret.length+1];
            n[0]= carry;
            for (int i=1;i<n.length;i++){
                n[i] = ret[i-1];
            }
            return n;
        }
        return ret;
    }
}
