package arrays.pepcoding;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsets {
    public static void recursive(int[] arr, int ind, List<Integer> ansSf){
        if(ind== arr.length){ System.out.println(ansSf); return;}
        recursive(arr,ind+1,ansSf);
        ansSf.add(arr[ind]);
        recursive(arr, ind+1, ansSf);
        ansSf.remove(ansSf.size()-1);
    }
    public static void iterative(int [] arr){
        int noOfSubsets = (int) Math.pow(2,arr.length);
        for (int i = 0; i < noOfSubsets; i++) {
            int temp = i;
            String  set = "";
            for (int j = arr.length-1; j >=0 ; j--) {
                int r = temp%2;
                temp = temp/2;
                if(r==0){
                    set = "-\t"+set;
                }
                else {
                    set = arr[j]+"\t"+set;
                }
            }
            System.out.println(set+" "+ i);
        }
    }

    public static void main(String[] args) {
        recursive(new int [] {1,2,3},0,new ArrayList<>());
        System.out.println(       );
        iterative(new int [] {1,2,3});
    }
}
