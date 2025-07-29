package csesProblems;

import java.util.Scanner;

public class NumberSpiral {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int testCases = s.nextInt();
        for (int i = 0; i < testCases; i++) {
            int y = s.nextInt();
            int x = s.nextInt();
            int m = Math.max(x,y);
            int diagonal = m*(m-1)+1;
            int diff = x-y;
//            if(m%2==0){
//                if(x<y)
//            }
        }
    }
}
