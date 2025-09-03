package recursion.l1;

public class MaxOfArray {
    public static int max(int [] nums,int index){
        if (index== nums.length) return 0;
        int got = max(nums,index+1);
        return Math.max(nums[index], got);
    }

    public static void main(String[] args) {
        System.out.println(max(new int[]{1,2,3,4,5,65,78,7,8,9},7));
    }
}
