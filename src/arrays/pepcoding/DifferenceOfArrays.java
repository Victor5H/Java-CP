package arrays.pepcoding;

public class DifferenceOfArrays {
    public static void difference(int [] nums1, int [] nums2){
        int max = Math.max(nums1.length, nums2.length);
//        nums2-nums1, nums2 is bigger
        int [] result = new int[nums2.length];
        int point2= nums2.length-1,point1= nums1.length-1,pointRest = result.length-1;
        int carry = 0;
        while (point1>=0 && point2>=0){
            int op2 = nums2[point2];
            int op1 = nums1[point1];
            int res = 0;
            op2=op2+carry;
            if(op1>op2){
                op2+=10;
                carry = -1;
            }
            else {
                carry=0;
            }
            res = op2-op1;
            result[pointRest--] = res;
            point1--;
            point2--;
        }
        while (point2>=0){
            if (carry ==-1){
                result[pointRest--] = nums2[point2--]+carry;
                carry=0;
            }
            else result[pointRest--] = nums2[point2--];
        }
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
    }

    public static void main(String[] args) {
        difference(new int[]{9,9,9,9,9},new int[]{1,2,3,4,5,9,0});
    }
}
