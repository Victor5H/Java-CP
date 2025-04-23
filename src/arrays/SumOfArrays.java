package arrays;

import java.util.Arrays;

public class SumOfArrays {
    public static void sum(int [] nums1,int [] nums2){
        int max = Math.max(nums1.length, nums2.length);
        int [] ret = new int[max];
        int pointRet = max-1,pointNum1= nums1.length-1,pointNum2=nums2.length-1;
        int carry=0;
        while (pointNum2>=0 && pointNum1>=0){
            int sum = nums1[pointNum1--]+nums2[pointNum2--]+carry;
            ret[pointRet--] =sum%10;
            sum=sum/10;
            carry=sum;
        }
        while (pointNum1>=0){
            int sum = nums1[pointNum1--]+carry;
            ret[pointRet--] = sum%10;
            sum=sum/10;
            carry=sum;
        }
        while (pointNum2>=0){
            int sum = nums2[pointNum2--]+carry;
            ret[pointRet--] = sum%10;
            sum=sum/10;
            carry=sum;
        }
        if(carry!=0){
            System.out.print(carry);
        }
        for (int i = 0; i < ret.length; i++) {
            System.out.print(ret[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
       sum(new int[]{1,2,3,4,5,6,7,8},new int[]{1,2,3,4,5});
    }
}
