package arrays;

import java.util.Arrays;

public class ReverseAnArray {
//    pepcoding
    public static void reverse(int [] arr, int l, int h){
        int i=l,j=h;
        while (i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        int j = arr.length-1;
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length/2; i++) {
            int temp = arr[i];
            arr[i] = arr[j-i];
            arr[j-i] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
