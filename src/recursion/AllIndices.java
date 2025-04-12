package recursion;

import java.util.Arrays;

public class AllIndices {
    public static int [] allIndices(int [] nums, int find, int index, int fsf){
        if(nums.length==index) return new int[fsf];
        if(nums[index]==find) fsf++; // pre call part to count the number of occurrence
        int [] ret = allIndices(nums,find,index+1,fsf);
        if(nums[index]==find){ // post call part to insert the index of occurrence and decrementing fsf
            ret[--fsf]=index;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(allIndices(new int[]{5,1,2,34,5,5,5,6,7,8,54,3,5},5,0,0)));

    }
}
