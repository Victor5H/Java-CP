package daily.TwentyFive.nineteenApril;

public class RotatedAndSorted {
    public static boolean sortedAndRotated(int [] nums){
        int count =0;
        for (int i = 0; i < nums.length; i++) {
            int next = nums[(i+1)% nums.length];
            int curr = nums[i];
            if(curr>next) count++;
        }
        return count<=1;
    }

    public static void main(String[] args) {
        System.out.println(sortedAndRotated(new int[]{4,6,5,1,2,3}));
    }
}
