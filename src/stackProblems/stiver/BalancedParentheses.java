package stackProblems;

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
                char peek=78;
                if(!stack.isEmpty())
                    peek = stack.peek();
                else return false;
                if(curr==')' && peek=='(') stack.pop();
                else if (curr=='}' && peek=='{') stack.pop();
                else if  (curr==']' && peek=='[') stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String string = "(()";
        System.out.println(isBalanced(string));
    }
}
