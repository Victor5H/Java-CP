package leetcode.interview150;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int i=0;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1]; // Replace with last valid element
                n--; // Reduce size
            } else {
                i++;
            }
        }

        return n;
    }
}
