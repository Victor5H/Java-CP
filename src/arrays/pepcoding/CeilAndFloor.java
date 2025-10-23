package arrays.pepcoding;

public class CeilAndFloor {
    public static void myWay(int [] arr, int val){
        int l=0,h= arr.length-1;
        int ceil =Integer.MAX_VALUE,floor=Integer.MIN_VALUE;
        while (l<=h && l>=0 && h<arr.length){
            int mid = l+(h-l)/2;
            if(arr[mid]==val){
                ceil = arr[mid];
                floor=arr[mid];
                break;
            } else if (arr[mid] < val) {
                l=mid+1;
                floor=arr[mid];
            } else if (arr[mid] > val) {
                h = mid-1;
                ceil = arr[mid];
            }
        }
        System.out.println("Floor is "+floor);
        System.out.println("Ceil is "+ceil);
    }
    public static void main(String[] args) {
        int [] num = new int[] {1,2,3,4,6,7,8,9};
//        sorted arrays only
        myWay(num,10);
    }
}
