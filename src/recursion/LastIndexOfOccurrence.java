package recursion;

public class LastIndexOfOccurrence {
    public static int lastOccurrence(int [] nums, int find, int index){
        if(index== nums.length) return -1;
        int ind = lastOccurrence(nums,find,index+1);
        if(ind ==-1 && nums[index] ==find) return index;
        return ind;
    }

    public static void main(String[] args) {
        System.out.println(lastOccurrence(new int[]{5,1,2,34,6,7,8,54,3,5},5,0));

    }
}
