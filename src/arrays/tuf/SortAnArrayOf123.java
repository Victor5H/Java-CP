package arrays.tuf;

import java.util.Arrays;

public class SortAnArrayOf123 {
    public static void bruteforce(int [] nums){
//        O(n^2)
        int o=0,t=0,z=0;
        for (int n: nums) {
            if(n==1) o++;
            else if (n==2) t++;
            else z++;
        }
        for (int i = 0; i < z; i++) {
            nums[i]=0;
        }
        for (int i = z; i < z+o; i++) {
            nums[i]=1;
        }
        for (int i = z+o; i < z+o+t; i++) {
            nums[i]=2;
        }
    }
    public static void optimal(int [] nums){
//        O(n)
        int l=0,m=0,h= nums.length-1;
        while (m<=h){
            if(nums[m]==0){
                int temp = nums[m];
                nums[m]=nums[l];
                nums[l] = temp;
                l++;m++;
            }
            else if(nums[m]==1){
                m++;
            }
            else {
                int temp = nums[m];
                nums[m]=nums[h];
                nums[h] = temp;
                h--;

            }
        }
    }

    public static void main(String[] args) {
        int [] nums = new int[]{0,2,1,0,2,1,1,1,1,0,0,0,2};
        System.out.println(Arrays.toString(nums));
        optimal(nums);
        System.out.println(Arrays.toString(nums));
    }

}
