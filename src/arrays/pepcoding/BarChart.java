package arrays.pepcoding;

public class BarChart {
    public static void barChart(int [] nums){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(max<nums[i]) max = nums[i];
        }
//        System.out.println(max);
        for (int i = max; i >0; i--) {
            for (int j = 0; j < nums.length; j++) {
                int n = nums[j];
                if(n<i) System.out.print("   ");
                else System.out.print(" * ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        barChart(new int[]{1,2,8,4,5,6,7,8,9});
    }
}
