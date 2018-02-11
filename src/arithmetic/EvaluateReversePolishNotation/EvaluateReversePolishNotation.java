package arithmetic.EvaluateReversePolishNotation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by tianle on 2/10/18.
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 */
public class EvaluateReversePolishNotation {

    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";

    private static final Set<String> validOperators = new HashSet<>(Arrays.asList(PLUS, MINUS, MULTIPLY, DIVIDE));

    public int evalRPN(String[] tokens) {

        if (tokens == null || tokens.length == 0) {
            return 0;
        }

        Stack<String> stack = new Stack<>();

        for (String s : tokens) {

            if (validOperators.contains(s)) {
                int second = Integer.valueOf(stack.pop());
                int first = Integer.valueOf(stack.pop());

                stack.push(String.valueOf(evaluate(first, second, s)));
            } else {
                stack.push(s);
            }
        }

        return Integer.valueOf(stack.pop());
    }

    private int evaluate(int first, int second, String operator) {
        if (PLUS.equals(operator)) {
            return first + second;
        }

        if (MINUS.equals(operator)) {
            return first - second;
        }

        if (MULTIPLY.equals(operator)) {
            return first * second;
        }

        return first / second;
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation e = new EvaluateReversePolishNotation();

//        String[] input = {"2", "1", "+", "3", "*"};

        String[] input = {"4", "13", "5", "/", "+"};

        System.out.println(e.evalRPN(input));

    }
}
