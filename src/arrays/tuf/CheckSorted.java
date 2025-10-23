package arrays.tuf;

public class CheckSorted {
    public static boolean isSorted(int []nums){
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]<nums[i-1]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,3,4,1};
        System.out.println("is sorted "+isSorted(nums));
    }
}
