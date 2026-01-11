package daily.TwentySix.eleventhJan;

public class LargetRectangleInHistogram {
    public static int bruteForce(int [] heights){
        int maxArea = Integer.MIN_VALUE,n = heights.length;
        for(int l=0;l<n;l++){
            int minH = heights[l];
            for (int r = l;r<n;r++){
                minH = Math.min(minH,heights[r]);
                int area  =(r-l+1)*minH;
                maxArea = Math.max(maxArea,area);
            }
        }
        return maxArea;
    }
    public static int myBruteForce(int [] heights){
        int maxArea = Integer.MIN_VALUE,n = heights.length;
        for(int i = 0;i< n;i++){
            int left = i-1;

            int right = i+1;

            while (left>=0 && heights[left]>=heights[i]){
                left--;
            }
            left++;
            while (right<n && heights[right]>=heights[i]){
                right++;
            }
            right--;
            int area = (right-left+1)*heights[i];
            maxArea = Math.max(area,maxArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int [] h = {2,4};
        System.out.println(bruteForce(h));
    }
}
