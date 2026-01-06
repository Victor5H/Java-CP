package daily.TwentyFive.twentySecondAug;
//https://leetcode.com/problems/find-the-minimum-area-to-cover-all-ones-i/
public class MaxAreaToCoverAllOnes {
    public int minimumArea(int[][] grid) {
        int mini=Integer.MAX_VALUE,minj=Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE,maxj=Integer.MIN_VALUE;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    mini = Math.min(i,mini);
                    minj = Math.min(j,minj);
                    maxj = Math.max(j,maxj);
                    maxi = Math.max(i,maxi);
                }
            }
        }
        int length = maxj-minj+1;
        int height = maxi-mini+1;
        return length*height;

    }
}
