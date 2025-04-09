package leetcode.interview150;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) {
                candidate = num; // selects a candidate
            }
            count += (num == candidate) ? 1 : -1; // counts the number of occurances of candidate
        }
        // just for confirmation
        int county=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==candidate) county++;
        }if (county> nums.length/2) return candidate;
        return 0;

//        return candidate;
    }

    public static void main(String[] args) {
//        System.out.println(MajorityElement.majorityElement(new int[]{2,2,1,1,1,2,2}));
        System.out.println(MajorityElement.majorityElement(new int[]{2,2,1,1,1,2,2,1}));
    }
}
