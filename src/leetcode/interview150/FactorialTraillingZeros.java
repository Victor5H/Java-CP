package leetcode.interview150;

public class FactorialTraillingZeros {
    public static int trailingZeroes(int n) {
        int count = 0;
        for (int i = 1; i <= 5; i++) {
            double pow = Math.pow(5, i);

            count += (int) (n / pow);

        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(6));
    }
}
