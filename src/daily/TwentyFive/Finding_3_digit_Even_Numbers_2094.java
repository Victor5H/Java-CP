package daily.TwentyFive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Finding_3_digit_Even_Numbers_2094 {
    public static int[] findEvenNumbers(int[] digits) {
        ArrayList<Integer> evenNums = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        List<Integer> digitsL = Arrays.stream(digits).boxed().collect(Collectors.toList());
        for (int i = 100; i <= 999; i += 2) {
            evenNums.add(i);
        }

        for (int i : evenNums) {
            int one = i % 10;
            int tenth = (i / 10) % 10;
            int hundred = i / 100;
            if (digitsL.contains(one)) {
                digitsL.remove(Integer.valueOf(one));

            } else continue;

            if (digitsL.contains(tenth)) {
                digitsL.remove(Integer.valueOf(tenth));
            } else {
                digitsL.add(one);
                continue;
            }
            if (digitsL.contains(hundred)) {
                ans.add(i);
                digitsL.add(tenth);
                digitsL.add(one);
            } else {
                digitsL.add(tenth);
                digitsL.add(one);
                continue;
            }
            //System.out.println(digitsL.contains(one) + " " + digitsL.contains(tenth) + " " + digitsL.contains(hundred));
            System.out.println(digitsL);
            System.out.println(i);

        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findEvenNumbers(new int []{2,1,3,0})));
    }
}
