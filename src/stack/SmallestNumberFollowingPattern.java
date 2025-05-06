package stack;

import java.util.Stack;

public class SmallestNumberFollowingPattern {
    public static void solve(String pattern){
        Stack<Integer> stack = new Stack<>();
        int count=1;
        for (int i = 0; i < pattern.length(); i++) {
            char curr = pattern.charAt(i);
            if (curr=='d'){  stack.push(count); count++;}
            else {
                stack.push(count);
                count++;
                while (!stack.isEmpty()){
                    System.out.print(stack.pop()+" ");
                }
            }
        }
//        for printing extra number at the end
        stack.push(count);
//        for printing any left out numbers in stack
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }

    public static void main(String[] args) {
        solve("ddidddid");
    }
}
