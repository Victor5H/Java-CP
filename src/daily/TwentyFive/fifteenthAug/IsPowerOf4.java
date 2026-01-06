package daily.TwentyFive.fifteenthAug;

public class IsPowerOf4 {
    public boolean isPowerOfFour(int n) {
        if(n<=0) return false;
        while(n%4==0 || n==1){
            if(n==1) return true;
            n=n/4;
        }
        return false;
    }
}
