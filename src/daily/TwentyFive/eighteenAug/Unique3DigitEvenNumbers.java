package daily.TwentyFive.eighteenAug;

import java.util.HashSet;

//https://leetcode.com/problems/unique-3-digit-even-numbers/
// usually it had to return the numbers in a sorted array, but now they are only asking for number of numbers
public class Unique3DigitEvenNumbers {
//    unoptimized, brute force;
    public int totalNumbers(int[] digits) {
        HashSet<Integer> set = new HashSet<>();
        int n = digits.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(i==j||j==k||i==k) continue;
                    else{
                        int num = digits[i]*100+digits[j]*10+digits[k];
                        if(num>=100 && num%2==0) set.add(num);
                    }
                }
            }
        }
        System.out.println(set);
        return set.size();//returns size, can use treeset to store numbers in a sorted order
    }


}
