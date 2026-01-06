package daily.TwentyFive.seventeenAug;
//https://leetcode.com/problems/power-of-two/
public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n==1) return true;
        if(n%2!=0||n==0) return false;
        return isPowerOfTwo(n/2);
    }
}
