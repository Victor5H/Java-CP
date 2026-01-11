package daily.TwentySix.eleventhJan;

import java.util.Stack;

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
    public static int BruteForceTUF(int [] heights){
//        find nse and pse array and find area
        int[] pse = PSE.pse(heights);
        int[] nse = NSE.nse(heights);
        int maxArea = Integer.MIN_VALUE,n = heights.length;
        for(int i = 0;i< n;i++){
            int l=pse[i];
            int r= nse[i];
            int area = (r-l-1)*heights[i];
            maxArea = Math.max(area,maxArea);
        }
        return maxArea;
    }
    public static int optimal(int [] heights){
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
//            bsd
            while (!stack.isEmpty() && heights[stack.peek()]> heights[i]){
                int ind = stack.pop();
                int nse = i;
                int pse = !stack.isEmpty()?stack.peek():-1;
                int area = (nse-pse-1)*heights[ind];
                maxArea = Math.max(area,maxArea);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            int nse = n;
            int ind = stack.pop();
            int pse = !stack.isEmpty()?stack.peek():-1;
            int area = (nse-pse-1)*heights[ind];
            maxArea = Math.max(area,maxArea);
        }
        return maxArea;

    }

    public static void main(String[] args) {
        int [] h = {2,4};
        System.out.println(BruteForceTUF(h));
    }
}
