package csesProblems.dynamicProgramming;

import java.util.Scanner;

public class RemovingDigits {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        int count = 0;
        while (n > 0) {
            String ns = String.valueOf(n);
            int large = ns.charAt(0) - '0';
            for (int i = 1; i < ns.length(); i++) {
                int cur = ns.charAt(i) - '0';
                if (cur > large) {
                    large = cur;
                }
            }
            count++;
            n = n - large;
        }
        System.out.println(count);
    }
}
