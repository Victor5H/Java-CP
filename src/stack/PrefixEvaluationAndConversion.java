package stack;

import java.util.Stack;

public class PrefixEvaluationAndConversion {
    public static int evaluateAndConvert(String exp){
        Stack<Integer> numStack = new Stack<>();
        Stack<String> postStack = new Stack<>();
        Stack<String> inStack = new Stack<>();
        for (int i = exp.length()-1; i >=0; i--) {
            char curr = exp.charAt(i);
            if(Character.isDigit(curr)){
                numStack.push(curr - '0');
                inStack.push(curr+"");
                postStack.push(curr+"");
            } else if(curr=='-'||curr=='*'||curr=='/'||curr=='+') {
                int val1 = numStack.pop();
                int val2 = numStack.pop();
                numStack.push(operation(val1,val2,curr));

                String va1 = inStack.pop();
                String va2 = inStack.pop();
                inStack.push('('+va1+curr+va2+')');

                va1 = postStack.pop();
                va2 = postStack.pop();
                postStack.push(va1+va2+curr);
            }
        }
        System.out.println("Infix: "+inStack.peek());
        System.out.println("Postfix: "+ postStack.peek());
        return numStack.peek();
    }
    public static int operation(int a1, int a2, char op){
        return switch (op) {
            case '+' -> a1 + a2;
            case '-' -> a1 - a2;
            case '*' -> a1 * a2;
            case '/' -> a1 / a2;
            default -> 0;
        };
    }

    public static void main(String[] args) {
        System.out.println(evaluateAndConvert("-+2/*6483"));
    }
}
