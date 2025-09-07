package dp.adityaVerma;

public class KnapSackBinary {
    static int [][]dp;
    public static int Myrecursion(int [] val, int[] wt, int ind, int bag){
        if(bag<0) return Integer.MIN_VALUE;
        if(ind==val.length)return 0;

        int take= val[ind]+ Myrecursion(val, wt, ind+1, bag-wt[ind]);
        int dint= Myrecursion(val, wt, ind+1, bag);
        return Math.max(take,dint);
    }
    public static int real(int [] val, int[] wt, int ind, int bag){
        if(ind==0|bag==0)
            return 0;
        if(wt[ind]>bag){
            return real(val, wt, ind-1, bag);
        }
        int take = val[ind]+real(val, wt, ind-1, bag-wt[ind]);
        int dont = real(val, wt, ind-1, bag);
        return Math.max(take,dont);
    }
    public static int dp(int [] val, int[] wt, int ind, int bag){
        if(ind==0|bag==0)
            return 0;
        if(dp[ind][bag]!=-1) return dp[ind][bag];
        if(wt[ind]>bag){
            return real(val, wt, ind-1, bag);
        }
        int take = val[ind]+real(val, wt, ind-1, bag-wt[ind]);
        int dont = real(val, wt, ind-1, bag);
        return dp[ind][bag]= Math.max(take,dont);
    }

    public static void main(String[] args) {
        int[] val = new int[]{2,1,3,2,4};
        int[] wt = new int[]{5,7,2,3,4};
        int w = 7;
        long st,end;
        st = System.nanoTime();
        Myrecursion(val,wt,0,w);
        end = System.nanoTime();
        System.out.println(end-st);
        st = System.nanoTime();
        real(val,wt, val.length-1, w);
        end = System.nanoTime();
        System.out.println(end-st);
        dp = new int[val.length][w+1];
        for (int i=0;i<dp.length;i++){
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        st = System.nanoTime();
        dp(val,wt, val.length-1,w );
        end = System.nanoTime();
        System.out.println(end-st);

    }
}
