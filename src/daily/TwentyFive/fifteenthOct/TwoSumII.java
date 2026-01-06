package daily.TwentyFive.fifteenthOct;

//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
public class TwoSumII {
    //    constant extra space
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, h = numbers.length - 1;
        while (l < h) {
            int sum = numbers[l] + numbers[h];
            if (sum > target) h--;
            else if (sum < target) l++;
            else return new int[]{l + 1, h + 1};
        }
        return new int[]{-1, -1};
    }

    public int[] twoSumFaltu(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int diff = target - numbers[i];
            int l = i + 1, h = numbers.length - 1;
            while (l <= h) {
                int mid = l + (h - l) / 2;
                if (numbers[mid] == diff) return new int[]{i + 1, mid + 1};
                if (numbers[mid] < diff) l = mid + 1;
                else h = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }
}
