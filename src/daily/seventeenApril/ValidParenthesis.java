package daily.seventeenApril;

import java.util.Stack;

public class ValidParenthesis {
    public static boolean validate(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            Character s = input.charAt(i);
            if (s.equals('(') || s.equals('{') || s.equals('[')) {
                stack.push(s);
            } else if (s.equals(')') || s.equals('}') || s.equals(']')) {
                if (stack.empty()) return false;
                char top = stack.pop();
                if ((s == '}' && top != '{') ||
                        (s == ')' && top != '(') ||
                        (s == ']' && top != '[')) return false;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(validate("()"));       // true
        System.out.println(validate("({[]})"));   // true
        System.out.println(validate("([)]"));     // false
        System.out.println(validate("((("));      // false
        System.out.println(validate(""));
    }
}
