package daily.fifthOct;

import java.util.Arrays;

public class ReverseArray {
    public static void reverse(int arr[], int st, int ed){
        if(st>=ed) return;
        int temp = arr[st];
        arr[st]=  arr[ed];
        arr[ed]=temp;
        reverse(arr, st+1, ed-1);
    }
    public static void main(String[] args) {
        int [] arr = new int[]{1,2,3,4,5,6,7,8};
        System.out.println(Arrays.toString(arr));
        reverse(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
