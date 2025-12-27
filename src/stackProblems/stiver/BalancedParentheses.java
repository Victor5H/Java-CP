package stackProblems.stiver;

import java.util.Stack;

public class BalancedParentheses {
    public static boolean isBalanced(String input){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char curr = input.charAt(i);
            if(curr == '{' || curr == '[' || curr == '('){
                stack.push(curr);
            }
            else{
                if(stack.isEmpty()) return false;
                char pop = stack.pop();
                if(curr=='}' && pop!='{') return false;
                if(curr==')' && pop!='(') return false;
                if(curr==']' && pop!='(') return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String string = "(()";
        System.out.println(isBalanced(string));
    }
}
