//package csesProblems.dynamicProgramming;


import java.util.Scanner;

public class ArrayDescription {
    public static long recursion(int ind, int[] arr, int m) {
        long count = 0;
        if (ind == arr.length - 1) {
            count = 0;
            if (arr[ind] == 0) {
                if (arr.length > 1) {
                    for (int i = 1; i <= m; i++) {
                        int diff = Math.abs(arr[ind - 1] - i);
                        if (diff <= 1) count++;
                    }
                } else count = m;
            } else count = 1;

        } else {
            count = 0;
            if (arr[ind] == 0) {
                for (int i = 1; i <= m; i++) {
                    int diff = Math.abs(arr[ind - 1] - i);
                    if (diff <= 1) {
                        count += recursion(ind + 1, arr, m);
                    }
                }
            } else count = recursion(ind + 1, arr, m);
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        System.out.println(recursion(0, arr, m));
    }
}