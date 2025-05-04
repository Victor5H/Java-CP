package stack;

import java.util.Stack;

public class InfixEvaluation {
    public static int evaluate(String exp){
//        assumptions are the numbers in expresion are single digit
//        +, - are same priority < / , *
//        left associative
        Stack<Character> opStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char curr = exp.charAt(i);
            if(curr == '('){opStack.push(curr);}
            else if(Character.isDigit(curr)) numStack.push(curr-'0');
            else if(curr==')'){
                while (opStack.peek()!='('){
                    int op2 = numStack.pop();
                    char op = opStack.pop();
                    int op1 = numStack.pop();
                    numStack.push(operation(op1,op2,op));
                }
                opStack.pop();
            }
//
            else if (curr=='-'||curr=='/'||curr=='+'||curr=='*') {
//                checks and processes until operators of higher equal precedence is found
                while (!opStack.isEmpty()
                        && opStack.peek()!='('
                        && precedence(opStack.peek())>=precedence(curr)){
                    int op2 = numStack.pop();
                    char op = opStack.pop();
                    int op1 = numStack.pop();
                    numStack.push(operation(op1,op2,op));
                }
                opStack.push(curr);
            }
        }
//        to process left out operations
        while (!opStack.isEmpty()){
            int op2 = numStack.pop();
            char op = opStack.pop();
            int op1 = numStack.pop();
            numStack.push(operation(op1,op2,op));
        }
        return numStack.peek();
    }
    public static int precedence(char op){
        return switch (op) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> 0;
        };
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
        System.out.println(evaluate("6*(2+3+5-4*8)/9+8"));
    }
}
