package arrays;

public class FirstAndLastIndex{
    public static void find(int []arr,int find){
        int l =0 ,h= arr.length-1;
        int li =-1,fi = -1;
        while (l<=h){
            int mid = l+(h-l)/2;
            if(arr[mid]==find){
                li = mid;
                l=mid+1;

            } else if (arr[mid] > find) {
                h = mid-1;
            }
            else {
                l = mid+1;
            }
        }
        System.out.println("Last Index "+li);
        l=0;h=arr.length-1;
        while (l<=h){
            int mid = l+(h-l)/2;
            if(arr[mid]==find){
                fi = mid;
                h=mid-1;

            } else if (arr[mid] > find) {
                h = mid-1;
            }
            else {
                l = mid+1;
            }
        }
        System.out.println("First Index "+fi);
    }

    public static void main(String[] args) {
        int [] arr = new int[]{1,2,2,2,2,2,3,4,4,4,4,5,5,5,5,6};
        find(arr,2);
    }
}
