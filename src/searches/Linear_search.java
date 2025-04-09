package searches;

import java.util.Arrays;
import java.util.Scanner;

public class Linear_search {
    public static int linear_search (int[] arr, int find) throws Exception{
        for(int i=0;i<arr.length;i++){
            if(arr[i]==find)
                return i;
        }
        return -1;
    }
    public static int linear_search(String str,char find){
        StringBuffer sb = new StringBuffer(str);
        for (int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i)==find){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        int []arr={4,5,2,45,6,346,4567,3,22,34};
        String demo="harshit";
        System.out.println(Arrays.toString(arr));
        Scanner s = new Scanner(System.in);
        int find = s.nextInt();
        System.out.println("found at index "+linear_search(arr,find));
        System.out.println("found at index "+linear_search(demo,'h'));
    }
}
