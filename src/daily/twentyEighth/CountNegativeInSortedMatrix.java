package daily.twentyEighth;

public class CountNegativeInSortedMatrix {
    public static int countNegatives(int[][] grid) {
//        O(mlogN)
        int l=0,h=grid[0].length-1,mid=0,count=0;
        for(int i=0;i<grid.length;i++){
            int []arr = grid[i];
            l=0;h=grid[0].length-1;
            if(arr[h]<0){
                if(arr[l]<0){
                    count+=(h-l)+1;
                }
                else{
                    while(l<=h){
                        mid = l+(h-l)/2;
                        if(arr[mid]<0){
                            count+=(h-mid)+1;
                            h=mid-1;
                        }
                        else{
                            l=mid+1;
                        }
                    }
                }
            }
        }
        return count;
    }
//    O(m+n)
    public int countNegativesMPlusN(int[][] grid) {
        int m=grid[0].length,n=grid.length,count=0,i=n-1,j=0;
        while(i>=0 && j<m){
            if(grid[i][j]<0){
                count+=(m-j);
                i--;
            }
            else{
                j++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int [][]grid = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        System.out.println(countNegatives(grid));
    }
}
