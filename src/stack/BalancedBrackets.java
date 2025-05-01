package stack;

import java.util.Stack;

public class BalancedBrackets {
    public static boolean bb(String input){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char curr = input.charAt(i);
            if(curr=='(' || curr=='{'|| curr=='['){
                stack.push(curr);
            }
            if(curr==')'|| curr=='}'|| curr==']'){
                if(stack.empty()) return false;
                char pop = stack.pop();
                if (curr==')' && pop!='(') return false;
                if (curr=='}' && pop!='{') return false;
                if (curr==']' && pop!='[') return false;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(
                bb("([[[]]]}")
        );
    }
}
