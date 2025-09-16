package dp.pepCoding;

import java.util.Arrays;

public class CountBinaryStrings {
//    count of all binary strings with given length, where 0 does not occur consecutively more than 1.
    public static void main(String[] args) {
        int length =6;
        int [][] t = new int[2][length+1];
//        2d matirx to store length of string stating with one and zero, following the given condition
        t[0][1]=1;t[1][1]=1;
        for (int i = 2; i < t[0].length; i++) {
            t[1][i] = t[0][i-1]+t[1][i-1];
            t[0][i] = t[1][i-1];
        }
        System.out.println(Arrays.deepToString(t));
        System.out.println("Ans is: "+(t[0][length]+t[1][length]));
//        without array
        int one=0,zero=0,no=1,nz=1;
        for (int i = 1; i < length; i++) {
            one = no;zero=nz;
            no = one+zero;
            nz = one;
        }
        System.out.println(nz+" "+no);
        System.out.println("Ans is: "+(nz+no));
    }
}
