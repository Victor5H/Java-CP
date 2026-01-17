package daily.TwentySix.seventeenthJan;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {

        //need to optimize the space

        int n = nums.length;
        int[] ret = new int[n];
        int[] pre = new int[n];
        int[] suf = new int[n];
        pre[0] = 1;
        for (int i = 1; i < n; i++) {
            pre[i] = nums[i - 1] * pre[i - 1];
        }
        suf[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suf[i] = nums[i + 1] * suf[i + 1];
        }
        for (int i = 0; i < n; i++) {
            ret[i] = pre[i] * suf[i];
        }
        return ret;
    }
}
