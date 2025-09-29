package dp.tuf;


import java.util.Arrays;

public class NinjasTraining {
    public static int recursion(int[][] mat, int day, int lastDayExercise){
        if(day==0){
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < mat[day].length; i++) {
                if(i!=lastDayExercise)
                    max = Math.max(mat[day][i],max);
            }
            return max;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < mat[day].length; i++) {
            if(i!=lastDayExercise)
                max = Math.max(recursion(mat, day-1, i)+mat[day][i],max);
        }
        return max;
    }
    static int [][]dp;
    public static int memoization(int[][] mat, int day, int lastDayExercise){

        if(day==0){
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < mat[day].length; i++) {
                if(i!=lastDayExercise)
                    max = Math.max(mat[day][i],max);
            }
            return dp[day][lastDayExercise]=max;
        }
        if(dp[day][lastDayExercise]!=-1)return dp[day][lastDayExercise];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < mat[day].length; i++) {
            if(i!=lastDayExercise) {
                max = Math.max(memoization(mat, day - 1, i) + mat[day][i], max);
            }
        }
        return dp[day][lastDayExercise]=max;
    }

    public static void main(String[] args) {
        int [][]mat = new int[][]{
                {2,1,3},
                {3,4,6},
                {10,1,6},
                {8,3,7}
        };
        System.out.println(recursion(mat, mat.length-1, mat[0].length));
        dp = new int[mat.length][mat[0].length+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],-1);
        }
        System.out.println(memoization(mat,mat.length-1,mat[0].length));
        int [][]t = new int[mat.length][mat[0].length+1];
        for (int i = 0; i < mat[0].length; i++) {
            int finalI = i;
            t[0][i] = Arrays.stream(mat[0]).filter(n->n!=mat[0][finalI]).max().orElse(Integer.MIN_VALUE);
        }
//        for last task
        t[0][t[0].length-1] = Arrays.stream(mat[0]).max().orElse(Integer.MIN_VALUE);
////    tabulation
        for (int day = 1; day < t.length; day++) {
            for (int task = 0; task < t[0].length; task++) {
                int max = Integer.MIN_VALUE;
                for (int i = 0; i < mat[day].length; i++) {
                    if(i!=task) {
                        max = Math.max(t[day-1][i] + mat[day][i], max);
                    }
                }
                t[day][task] = max;
            }

        }
        System.out.println(Arrays.toString(t[0]));
        System.out.println(Arrays.toString(t[t.length-1]));
        System.out.println(t[t.length-1][t[0].length-1]);
////    space optimization
        int []prev = new int[mat[0].length+1];
        for (int i = 0; i < mat[0].length; i++) {
            int finalI = i;
            prev[i] = Arrays.stream(mat[0]).filter(n->n!=mat[0][finalI]).max().orElse(Integer.MIN_VALUE);
        }
//        for last task
        prev[prev.length-1] = Arrays.stream(mat[0]).max().orElse(Integer.MIN_VALUE);
        for (int day = 1; day < t.length; day++) {
            int [] curr = new int[mat[0].length+1];
            for (int task = 0; task < t[0].length; task++) {
                int max = Integer.MIN_VALUE;
                for (int i = 0; i < mat[day].length; i++) {
                    if(i!=task) {
                        max = Math.max(prev[i] + mat[day][i], max);
                    }
                }
                curr[task] = max;
            }
            prev = curr;

        }
        System.out.println(prev[prev.length-1]);

    }
}
