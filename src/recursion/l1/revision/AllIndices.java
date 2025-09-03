package recursion.l1.revision;

import java.util.Arrays;

public class AllIndices {
    public static int [] allIndices(int [] arr, int find, int ind,int fsf){
        if(ind== arr.length) return new int[fsf];
        if(arr[ind]==find) fsf++;
        int[] got = allIndices(arr,find,ind+1,fsf);
        if(arr[ind]==find) got[--fsf]=ind;
        return got;
    }
    public static void main(String[] args) {
        int [] arr = new int[]{1,2,2,2,2,2,2,3,3,3,3,3,3,4,4,4,4};
        System.out.println(Arrays.toString(allIndices(arr,3,0,0)));
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i+" "+arr[i]);
        }
    }
}
