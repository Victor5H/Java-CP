package stackProblems;

import java.util.Stack;

public class DuplicateBrackets {
    public static boolean check(String str){
        int i=0;
        Stack<Character> stack = new Stack<>();
        while(i<str.length()){
            char curr = str.charAt(i);
            if(curr==')'){
                if(stack.peek()=='(') return true;
                while (stack.pop()!='('){}
            }
            else stack.push(curr);
            i++;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(check("(a+(b)+((c)))"));
    }
}
