package dp.adityaVerma;

import java.util.Arrays;

public class RodCuttingProblem {
    public static void main(String[] args) {
        int[] length = new int[]{1,2,3,4,5,6,7,8};
        int [] price = new int[]{1,5,8,9,10,17,17,20};
        int rodSize = 8;
        int []t = new int[rodSize+1];
        for (int i = 1; i < t.length; i++) {
            for (int j = 0; j < length.length; j++) {
                if(length[j]<=i){
                    int cut = t[i-length[j]]+price[j];
                    t[i] = Math.max(t[i],cut);
                }
            }
        }
        System.out.println(Arrays.toString(t));
    }
}
