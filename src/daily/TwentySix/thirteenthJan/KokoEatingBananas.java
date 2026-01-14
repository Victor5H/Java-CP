package daily.TwentySix.thirteenthJan;

import java.util.Arrays;
//https://leetcode.com/problems/koko-eating-bananas/
public class KokoEatingBananas {
    int [] piles = null;
    public long hours(int speed){
        long hrs=0;

        for(int b: piles){
            hrs+=(long)Math.ceil((double)b/speed);
        }
        return hrs;
    }
    public int minEatingSpeed(int[] piles, int hrs) {
        int max= Arrays.stream(piles).max().getAsInt();
        this.piles = piles;
        int l = 1,h=max, mid=0;
        while(l<=h){
            mid = (h+l)/2;
            if(hours(mid)>hrs){
                l=mid+1;
            }
            else{
                h = mid-1;
            }
        }
        // for(long i=1;i<=max;i++){
        //     if(hours(i)<=hrs){
        //         return (int)i;
        //     }
        // }
        return l;
    }
}
