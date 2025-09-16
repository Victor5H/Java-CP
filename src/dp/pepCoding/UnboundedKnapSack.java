package dp.pepCoding;

import java.util.Arrays;

public class UnboundedKnapSack {
    public static void main(String[] args) {
//        problem is similar to coin change permutation or combination
//        https://www.youtube.com/watch?v=jgps7MXtKRQ&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=17
        int [] wt = new int[]{2,5,1,3,4};
        int [] val = new int[]{15,14,10,45,30};
        int w = 7;
        int []t = new int[w+1];
        for (int i = 1; i < t.length; i++) {
            for (int j = 0; j < wt.length; j++) {
                if(wt[j]<=i){
                    int take = t[i-wt[j]]+val[j];
                    t[i] =Math.max(take,t[i]);
                }
            }
        }
        System.out.println(Arrays.toString(t));
    }
}
