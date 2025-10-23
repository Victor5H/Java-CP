package arrays.pepcoding;

public class SpanOfArray {
    public static int span(int [] nums){
        int max  = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if(n<min) min=n;
            if(n>max) max = n;
        }
        return max-min;
    }

    public static void main(String[] args) {
        System.out.println(span(new int[]{1,2,90}));
    }
}
