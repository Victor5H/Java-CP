package stackProblems;

import java.util.Stack;

public class InfixConversion {
    public static void evaluate(String exp){
//        assumptions are the numbers in expresion are single digit
//        +, - are same priority < / , *
//        left associative
        Stack<Character> opStack = new Stack<>();
        Stack<String> preStack = new Stack<>();
        Stack<String > postStack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char curr = exp.charAt(i);
            if(curr == '('){opStack.push(curr);}
            else if(Character.isDigit(curr)){
                preStack.push(String.valueOf(curr));
                postStack.push(String.valueOf(curr));
            }
            else if(curr==')'){
                while (opStack.peek()!='('){
                    String  op2 = preStack.pop();
                    char op = opStack.pop();
                    String op1 = preStack.pop();
                    preStack.push(op+op1+op2);

                    op2 = postStack.pop();
                    op1 = postStack.pop();
                    postStack.push(op1+op2+op);
                }
                opStack.pop();
            }
//
            else if (curr=='-'||curr=='/'||curr=='+'||curr=='*') {
//                checks and processes until operators of higher equal precedence is found
                while (!opStack.isEmpty()
                        && opStack.peek()!='('
                        && precedence(opStack.peek())>=precedence(curr)){
                    String  op2 = preStack.pop();
                    char op = opStack.pop();
                    String op1 = preStack.pop();
                    preStack.push(op+op1+op2);

                    op2 = postStack.pop();
                    op1 = postStack.pop();
                    postStack.push(op1+op2+op);
                }
                opStack.push(curr);
            }
        }
//        to process left out operations
        while (!opStack.isEmpty()){
            String  op2 = preStack.pop();
            char op = opStack.pop();
            String op1 = preStack.pop();
            preStack.push(op+op1+op2);

            op2 = postStack.pop();
            op1 = postStack.pop();
            postStack.push(op1+op2+op);
        }
        System.out.println(preStack.peek());
        System.out.println(postStack.peek());
    }
    public static int precedence(char op){
        return switch (op) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> 0;
        };
    }

    public static void main(String[] args) {
       evaluate("6*(2+3+5-4*8)/9+8");
    }
}
