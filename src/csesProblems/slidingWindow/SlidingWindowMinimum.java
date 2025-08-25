package csesProblems.slidingWindow;

import java.util.*;

public class SlidingWindowMinimum {
    public static long [] generate(long n,long x, long a, long b, long c){
        long [] arr = new long[(int)n];
        arr[0]= x;
        for (int i = 1; i < arr.length; i++) {
            arr[i] =(a* arr[i-1] +b)%c;
        }
        return arr;
    }
    public static long calculateMin(long [] arr, long k){
        long minXor = 0;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty()&&arr[deque.peekLast()]>arr[i]){
                deque.pollLast();
            }
            deque.offerLast(i);

        }
        for (int i = Math.toIntExact(k); i < arr.length; i++) {
            minXor^=arr[deque.peekFirst()];
            while (!deque.isEmpty()&&deque.peekFirst()<i-k+1){ // getting out indices out of the current window
                deque.pollFirst();
            }
            while (!deque.isEmpty()&&arr[deque.peekLast()]>arr[i]){
                deque.pollLast();
            }
            deque.offerLast(i);

        }
        minXor^=arr[deque.peekFirst()];
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
        System.out.print(calculateMin(arr,k));
    }
}
