package recursion.l1.revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TargetSumSubset {
    public static void levelOrder(int[] que,String set,int ind, int sum, int currentSum){
        if(ind==que.length){
            if(currentSum==sum){ System.out.println(set);return ;}
            return;
        }
        if(currentSum>sum)return;
        levelOrder(que,set+que[ind]+",",ind+1,sum,currentSum+que[ind]);
        levelOrder(que,set,ind+1,sum,currentSum);
    }

    public static void main(String[] args) {
        int [] set = {10,20,30,40,50,60,70};
        levelOrder(set,"",0,100,0);
    }
}
