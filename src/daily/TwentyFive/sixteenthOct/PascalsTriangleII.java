package daily.TwentyFive.sixteenthOct;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/pascals-triangle-ii/
public class PascalsTriangleII {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> prev = new ArrayList<>();
        prev.add(1);
        for(int i=1;i<=rowIndex;i++){
            List<Integer> nums = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0||j==i) nums.add(1);
                else{
                    nums.add(prev.get(j-1)+prev.get(j));
                }
            }
            prev = nums;
        }
        return prev;
    }

    public static void main(String[] args) {
        System.out.println(getRow(1));
    }
}
