package dp.pepCoding;

import java.util.Arrays;

public class ArrangeBuildings {
//    this problem is similar to count binary strings
//    in this a road divides vertical plots in half,
//    on either side of road, the plots and have empty space but no 2 or more building consecutively.
    public static void main(String[] args) {
        int length = 45;
        long [][]t = new long[2][length+1];
        t[0][1]=1; //building
        t[1][1]=1; // space
        for (int i = 2; i < t[0].length; i++) {
            t[0][i] = t[1][i-1];
            t[1][i]=t[0][i-1]+t[1][i-1];
        }
        long ansForOneSide = t[0][length]+t[1][length];
//        since for each combination of one side, there will be all other on the other side
        long ansForBothSides = ansForOneSide*ansForOneSide;
        System.out.println(ansForBothSides);

    }
}
