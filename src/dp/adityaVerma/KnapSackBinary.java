package dp.adityaVerma;

public class KnapSackBinary {
    static int [][]dp;
    public static int myRecursion(int [] val, int[] wt, int ind, int bag){
        if(bag<0) return Integer.MIN_VALUE;
        if(ind==val.length)return 0;

        int take= val[ind]+ myRecursion(val, wt, ind+1, bag-wt[ind]);
        int dint= myRecursion(val, wt, ind+1, bag);
        return Math.max(take,dint);
    }
    public static int real(int [] val, int[] wt, int n, int w){
        if(n==0| w ==0)
            return 0;
        if(wt[n-1]<= w){
            int take = val[n-1]+real(val, wt, n-1, w -wt[n-1]);
            int dont = real(val, wt, n-1, w);
            return Math.max(take,dont);
        }

        return real(val, wt, n-1, w);

    }
    public static int memoization(int [] val, int[] wt, int n, int w){
        if(n==0| w ==0)
            return 0;
        if(dp[n-1][w]!=-1) return dp[n-1][w];
        if(wt[n-1]<= w){
            int take = val[n-1]+real(val, wt, n-1, w -wt[n-1]);
            int dont = real(val, wt, n-1, w);
            return Math.max(take,dont);
        }

        return dp[n-1][w]=real(val, wt, n-1, w);
    }

    public static void main(String[] args) {
        int[] val = new int[]{15,14,10,45,30};
        int[] wt = new int[]{2,5,1,3,4};
        int n= val.length;
        int w = 7;
       // System.out.println(myRecursion(val,wt,0,w));
        System.out.println(real(val,wt, val.length, w));

        dp = new int[n+1][w+1];
        for (int i=0;i<dp.length;i++){
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(memoization(val,wt, val.length,w ));

        int [][] t = new int[val.length+1][w+1];
// init t
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j <t[0].length; j++) {
                if(i==0||j==0) t[i][j]=0;
                else
                {
                    t[i][j]=-1;
                }
            }

        }
        for (int i = 1; i <t.length; i++) {
            for (int j = 1; j <t[0].length ; j++) {
                if(wt[i-1]<=j){
                    int take = val[i-1]+t[i-1][j-wt[i-1]];
                    int dont = t[i-1][j];
                    t[i][j] = Math.max(take,dont);
                }
                else {
                    t[i][j] = t[i-1][j];
                }
            }
        }

        System.out.println(t[n][w]);

    }
}
