package csesProblems.slidingWindow;

import java.util.Scanner;

public class SlidingWindowSum {
    public static long [] generate(long n,long x, long a, long b, long c){
        long [] arr = new long[(int)n];
        arr[0]= x;
        for (int i = 1; i < arr.length; i++) {
            arr[i] =(a* arr[i-1] +b)%c;
        }
        return arr;
    }
    public static long calculateSum(long [] arr, long k){
        int n = arr.length;
        int window = (int) k; // Cast to int for array indexing
        long currentSum = 0;
        long sumXor = 0;

        // Compute the sum of the first window
        for (int i = 0; i < window; i++) {
            currentSum += arr[i];
        }
        sumXor = currentSum;

        // Slide the window across the array
        for (int i = window; i < n; i++) {
            currentSum = currentSum - arr[i - window] + arr[i];
            sumXor ^= currentSum;
        }

        return sumXor;
    }
    public static void main(String[] args) {
        long n = 8;
        long k = 5,x=3,a=7,b=1,c=11;
        Scanner s = new Scanner(System.in);
//        n=s.nextLong();
//        k=s.nextLong();
//        x=s.nextLong();
//        a = s.nextLong();
//        b = s.nextLong();
//        c = s.nextLong();
        long [] arr = generate(n,x,a,b,c);
        System.out.print(calculateSum(arr,k));
    }
}
