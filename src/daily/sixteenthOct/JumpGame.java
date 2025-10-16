package daily.sixteenthOct;
//https://leetcode.com/problems/jump-game/?envType=problem-list-v2&envId=array
public class JumpGame {
    public static boolean canJump(int[] nums) {

        boolean[] t = new boolean[nums.length];

        t[t.length - 1] = true;
        for (int i = t.length - 2; i >= 0; i--) {
            boolean res = false;
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j < t.length) {
                    res = res || t[i + j];
                }
                if (res) break;
            }
            t[i] = res;
        }
        return t[0];
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
