package daily.TwentySix.twelvethJan;
//https://leetcode.com/problems/minimum-time-visiting-all-points/
public class MinimumTimeVisitingAllPoints {
//    easy, solved in first try
    public int mySol(int[][] points) {
        int time = 0;
        int [] start = points[0];
        for(int i=1;i<points.length;i++){
            int []target = points[i];
            int []diff = {Math.abs(target[0]-start[0]),Math.abs(target[1]-start[1])};
            int max = Math.max(diff[0],diff[1]);
            time+=max;
//            time+=max-min;
            start = points[i];
        }
        return time;
    }
}
