package arrays.tuf;

public class SecondLargestAndSmallest {
    public static void find(int [] nums){
        int l=Integer.MIN_VALUE,sl=Integer.MIN_VALUE;
        int s=Integer.MAX_VALUE,ss = Integer.MAX_VALUE;
        for(int n:nums){
            if(n>l){
                sl=l;
                l=n;
            }
            else if (n>sl && n<l){
                sl=n;
            }
            if(n<s){
                ss=s;
                s = n;
            }
            else if(n<ss&&n>s){
                ss=n;
            }
        }
        System.out.println("largest is "+l+" smallest is "+s);
        System.out.println("second Smallest is "+ss+" second largest is "+sl);
    }

    public static void main(String[] args) {
        int []nums = new int[]{1,99};
        find(nums);
    }
}
