package daily.TwentyFive.sixteenthOct;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/pascals-triangle/
public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> prev = null;
        for(int i=1;i<=numRows;i++){
            List<Integer> nums = new ArrayList<>();
            for(int j=0;j<i;j++){
                if(j==0||j==i-1) nums.add(1);
                else{
                    nums.add(prev.get(j-1)+prev.get(j));
                }
            }
            prev = nums;
            ret.add(nums);
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
