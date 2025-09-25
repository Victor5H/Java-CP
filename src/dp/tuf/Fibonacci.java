package dp.tuf;

public class Fibonacci {
    public static void main(String[] args) {
        int prev2=0,prev=1,curr=0;
        int n = 5;
        for (int i = 2; i <= n; i++) {
            curr=prev+prev2;
            prev2 = prev;
            prev = curr;
        }
        System.out.println(prev);
        int [] t= new int[n+1];
        t[1]=1;
        for (int i = 2; i <=n; i++) {
            t[i] = t[i-1]+t[i-2];
        }
        System.out.println(t[n]);
    }
}
