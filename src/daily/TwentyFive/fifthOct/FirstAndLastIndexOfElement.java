package daily.TwentyFive.fifthOct;

public class FirstAndLastIndexOfElement {
    public static void firstAndLast(int []arr, int target){
        int first=-1,last=-1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==target) {
                if (first == -1) first = i;
                last = i;
            }
        }
        System.out.println(first+" "+last);
    }
    public static void main(String[] args) {
        int []arr = new int[]{1,2,3,1,2};
       firstAndLast(arr,0);
    }
}
