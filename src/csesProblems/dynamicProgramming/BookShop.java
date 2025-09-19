package csesProblems.dynamicProgramming;


import java.util.Arrays;
import java.util.Scanner;

public class BookShop {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int n = s.nextInt();
        int x = s.nextInt();
        int [] prices = new int[n];
        int [] pages = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i]=s.nextInt();
        }
        for (int i = 0; i < n; i++) {
            pages[i]=s.nextInt();
        }

        long []t = new long[x+1];
        for (int i = 0; i < n; i++) {
            for (int j = x; j >=0 ; j--) {
                if(prices[i]<=j){
                    long take = t[j-prices[i]]+pages[i];
                    long dont = t[j];
                    t[j] = Math.max(take,dont);
                }
            }
        }
        System.out.println(t[x]);
    }
}
