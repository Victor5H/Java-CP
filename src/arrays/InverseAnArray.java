package arrays;

import java.util.Arrays;

public class InverseAnArray {
    public static void main(String[] args) {
        int [] input = new int[]{3,4,2,1,0};
        int [] inverse = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            inverse[input[i]] = i;
        }
        System.out.println(Arrays.toString(input));
        System.out.println(Arrays.toString(inverse));
    }
}
