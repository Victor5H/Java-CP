package arrays.pepcoding;

import java.util.Arrays;

public class RotateAnArray {
    public static void Mera(int[] arr, int n) {
//        a bit faster
        n = n % arr.length;
        if (n < 0) {
            while (n < 0) {
                int first = arr[0];
                for (int i = 1; i < arr.length; i++) {
                    arr[i - 1] = arr[i];
                }
                arr[arr.length - 1] = first;
                n++;
            }
        } else if (n > 0) {
            while (n > 0) {
                int last = arr[arr.length - 1];
                for (int i = arr.length - 1; i > 0; i--) {
                    arr[i] = arr[i - 1];
                }
                arr[0] = last;
                n--;
            }
        }
    }
    public static void PepCoding(int [] arr, int k){
//                slower than mine
        k = k% arr.length;
        if(k<0){
            k = k+ arr.length;
        }
        reverse(arr,0, arr.length-k-1);
        reverse(arr, arr.length-k, arr.length-1);
        reverse(arr,0, arr.length-1);

    }
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
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int rotate = -2;
        System.out.println(Arrays.toString(arr));
        long st = System.nanoTime();
        Mera(arr, rotate);
//        PepCoding(arr,rotate);
        long end = System.nanoTime();
//        System.out.println(end-st);
        System.out.println(Arrays.toString(arr));
    }
}
