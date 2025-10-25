package io.github.cristianmanoliu.stack;

import java.util.Stack;

// https://neetcode.io/problems/evaluate-reverse-polish-notation?list=neetcode150
// https://leetcode.com/problems/evaluate-reverse-polish-notation
public class EvaluateReversePolishNotation {

  // Example of RPN: ["2","1","+","3","*"] -> ((2 + 1) * 3) = 9
  public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();

    for (String token : tokens) {
      // Check if token is an operator
      if (token.equals("+") || token.equals("-") ||
          token.equals("*") || token.equals("/")) {

        // Pop two operands (order matters!)
        int secondOperand = stack.pop();
        int firstOperand = stack.pop();

        // Apply operation and push result
        int result = applyOperation(firstOperand, secondOperand, token);
        stack.push(result);
      } else {
        // Token is a number, push to stack
        stack.push(Integer.parseInt(token));
      }
    }

    // Final result is the only value left on stack
    return stack.pop();
  }

  private int applyOperation(int first, int second, String operator) {
    return switch (operator) {
      case "+" -> first + second;
      case "-" -> first - second;
      case "*" -> first * second;
      case "/" -> first / second;  // Division truncates toward zero in Java
      default -> throw new IllegalArgumentException("Invalid operator: " + operator);
    };
  }
}
