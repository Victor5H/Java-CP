//package csesProblems.slidingWindow;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SlidingWindowMinimum {
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
        long min = Long.MAX_VALUE;
        long minXor = 0;
        HashSet<Long> set = new HashSet<>();
        PriorityQueue<Long> q = new PriorityQueue<>();

        // Compute the sum of the first window
        for (int i = 0; i < window; i++) {
            set.add(arr[i]);
            if(arr[i]<min) min = arr[i];
        }
        q.addAll(set);
        minXor = q.poll();

        // Slide the window across the array
        for (int i = window; i < n; i++) {
            set.remove(arr[i-window]);
            set.add(arr[i]);
            if(arr[i - window]==min){
                while (q.size()!=0) {
                    q.poll();
                }
                q.addAll(set);
                min = q.poll();
            } //calculate
            else{
                if(arr[i]<min) min=arr[i];
            }
             minXor ^= min;
        }

        return minXor;
    }
    public static void main(String[] args) {
        long n = 8;
        long k = 5,x=3,a=7,b=1,c=11;
        Scanner s = new Scanner(System.in);
        n=s.nextLong();
        k=s.nextLong();
        x=s.nextLong();
        a = s.nextLong();
        b = s.nextLong();
        c = s.nextLong();
        long [] arr = generate(n,x,a,b,c);
        System.out.print(calculateSum(arr,k));
    }
}
