package arrays.tuf;

import java.util.Arrays;

public class MissingNumber {
    public static int find(int []nums1, int n){
        int sum = Arrays.stream(nums1).sum();
        int forumla = n*(n+1)/2;
        return forumla-sum;
    }

    public static void main(String[] args) {
        int [] num = new int[]{1,2,3,4,5,6,7};
        System.out.println(find(num,7));
    }
}
