package arrays.pepcoding;

public class PrintAllSubarrays {
    public static void printSubarrays(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j <arr.length ; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k]+" ");
                }
                System.out.println(" ");
            }
        }
    }
    public static void helper(int []arr, int ind){
        for (int i = ind; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        printSubarrays(new int[]{1,2,3,4,5,6,7,8,9});
    }
}
