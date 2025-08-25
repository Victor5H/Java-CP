package sorts;

import java.util.Arrays;

public class MergeSort {
    public static int [] merge(int [] one, int [] two){
        int i=0,j=0,k=0;
        int[] ret = new int[one.length+ two.length];
        while (i< one.length&&j< two.length){
            if(one[i]>two[j]){
                ret[k++] = two[j++];
            }
            else{
                ret[k++]=one[i++];
            }
        }
        while (i< one.length){
            ret[k++]=one[i++];
        }
        while (j< two.length){
            ret[k++]=two[j++];
        }
        return ret;
    }
//    public static int [] mergeSort(int [] arr,int l, int h){
//        if(l<h){
//            int m = h+(l-h)/2;
//            mergeSort(arr,l,m);
//            mergeSort(arr,m+1,h);
//           // merge();
//        }
//    }

    public static void main(String[] args) {
        int [] one={1,3,4,6,9};
        int [] two = {2,5,8};
        System.out.println(Arrays.toString(merge(one,two)));
    }
}
