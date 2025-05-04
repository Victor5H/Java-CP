package stack;

import java.util.Stack;

public class PostfixEvaluationAndConversion {
    public static int evaluateAndConvert(String exp){
        Stack<Integer> numStack = new Stack<>();
        Stack<String> preStack = new Stack<>();
        Stack<String> inStack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char curr = exp.charAt(i);
            if(Character.isDigit(curr)){
                numStack.push(curr - '0');
                inStack.push(curr+"");
                preStack.push(curr+"");
            } else if(curr=='-'||curr=='*'||curr=='/'||curr=='+') {
                int val2 = numStack.pop();
                int val1 = numStack.pop();
                numStack.push(operation(val1,val2,curr));

                String va2 = inStack.pop();
                String va1 = inStack.pop();
                inStack.push('('+va1+curr+va2+')');

                va2 =preStack.pop();
                va1 = preStack.pop();
                preStack.push(curr+va1+va2);
            }
        }
        System.out.println("Infix: "+inStack.peek());
        System.out.println("Prefix: "+preStack.peek());
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
        System.out.println(evaluateAndConvert("264*8/+3-"));
    }
}
