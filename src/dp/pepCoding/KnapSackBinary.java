package dp.pepCoding;

import java.util.Arrays;

public class KnapSackBinary {
    public static void main(String[] args) {
        int [] wt = new int[]{2,5,1,3,4};
        int [] val = new int[]{15,14,10,45,30};
        int w = 7;
        int [][]t = new int[wt.length+1][w+1];
        for (int i = 1; i < t.length; i++) {
            for (int j = 1; j < t[0].length; j++) {
                if(wt[i-1]<=j){
                    int take = t[i-1][j-wt[i-1]]+val[i-1];
                    int dont = t[i-1][j];
                    t[i][j] = Math.max(take,dont);
                }
                else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        for (int i = 0; i < t.length; i++) {
            System.out.println(Arrays.toString(t[i]));
        }
    }
}
