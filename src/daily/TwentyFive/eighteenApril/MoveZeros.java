package daily.TwentyFive.eighteenApril;

import java.util.Arrays;

public class MoveZeros {
    public static void moveZeros(int [] nums){
//        int pointLast = nums.length-1,point=0;
//        while (point< pointLast){
//            if(nums[point]==0){
//                int temp = nums[point];
//                nums[point] = nums[pointLast];
//                nums[pointLast] = temp;
//                pointLast--;
//
//            }
//            point++;
//        }
//        System.out.println(Arrays.toString(nums));
//        not right since it doesnot maintain order of non zero elements
        int pointFirst=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                nums[pointFirst++]=nums[i];

            }

        }
        while (pointFirst< nums.length){
            nums[pointFirst++]=0;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        moveZeros(new int[]{0, 1, 0, 3, 12});
    }
}
