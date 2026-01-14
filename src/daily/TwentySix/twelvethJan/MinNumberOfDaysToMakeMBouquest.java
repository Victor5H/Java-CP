package daily.TwentySix.twelvethJan;

import java.util.Arrays;
//https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
public class MinNumberOfDaysToMakeMBouquest {
    public boolean isPossible(int [] bloomday, int m, int k, int day){
        int bouqets = 0,count=0;
        for(int i=0;i<bloomday.length;i++){
            if(day>=bloomday[i]){
                count++;
            }
            else{
                bouqets +=count/k;
                count=0;
            }
        }
        bouqets+=count/k;
        if(bouqets>=m) return true;
        return false;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int min = Arrays.stream(bloomDay).min().getAsInt();
        int max = Arrays.stream(bloomDay).max().getAsInt();
        int i=-1,l=min,h=max;
        while(l<=h){
            i = (h+l)/2;
            if(isPossible(bloomDay,m,k,i)==true){
                h=i-1;
            }
            else{
                l = i+1;
            }
        }
        return l>max?-1:l;
    }
}
