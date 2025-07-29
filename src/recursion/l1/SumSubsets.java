package recursion.l1;

public class SumSubsets {
    public static void printSumSubsets(int [] nums, int index, String set, int target, int sum){
        if (sum==target) {
            System.out.println(set);
            return;
        }
        if(index== nums.length){return;}

        printSumSubsets(nums,index+1,set+nums[index]+",",target, sum+nums[index]);
        printSumSubsets(nums,index+1,set,target,sum);
    }

    public static void main(String[] args) {
        printSumSubsets(new int[]{10,20,30},0,"",30,0);
    }
}
