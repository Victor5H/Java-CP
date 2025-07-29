package recursion.l1;

public class FirstIndexOfOccurrence {
    public static int firstOccurrence(int [] nums, int find, int index){
        if(index== nums.length) return -1;
        if (find == nums[index]) return index;
        return firstOccurrence(nums,find,index+1);
    }

    public static void main(String[] args) {
        System.out.println(firstOccurrence(new int[]{1,2,34,6,7,8,54,3,5},5,0));
    }
}
