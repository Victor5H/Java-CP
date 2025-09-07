package dp.pepCoding;


public class Fibonacci {
    public static int recursion(int n){
        if (n==0||n==1) return n;
        return recursion(n-1)+recursion(n-2);
    }
    public static int dp(int n, int[]dp){
        if (n==0||n==1) return n;
        if (dp[n]!=0)
            return dp[n];
        System.out.println("hello "+n);
        int one = dp(n-1,dp);
        int two = dp(n-2,dp);
        int ans = one+two;
        dp[n]=ans;
        return ans;
    }

    public static void main(String[] args) {
        long st,end;
        st = System.currentTimeMillis();
        System.out.println(recursion(40));
        end = System.currentTimeMillis();
        System.out.println(end-st);
        st = System.nanoTime();
        System.out.println(dp(40,new int[41]));
        end = System.nanoTime();
        System.out.println(end-st);
    }
}
