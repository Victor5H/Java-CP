package daily.sixteenApril;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static int [] twoSum(int [] nums, int sum){
        HashMap<Integer,Integer> map = new HashMap<>();
        int [] ret = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int check = sum - nums[i];
            if(map.containsKey(check)){
                ret[0]=i;
                ret[1]= map.get(check);
            }
            else{
                map.put(nums[i],i);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15},9)));
    }
}
