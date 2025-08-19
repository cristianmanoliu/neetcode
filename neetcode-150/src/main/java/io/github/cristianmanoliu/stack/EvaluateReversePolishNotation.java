package io.github.cristianmanoliu.stack;

// https://neetcode.io/problems/evaluate-reverse-polish-notation?list=neetcode150
// https://en.wikipedia.org/wiki/Reverse_Polish_notation
public class EvaluateReversePolishNotation {
  public int evalRPN(String[] tokens) {
    int[] stack = new int[tokens.length];
    int index = 0;
    for (String token : tokens) {
      switch (token) {
        case "+":
          stack[index - 2] += stack[index - 1];
          index--;
          break;
        case "-":
          stack[index - 2] -= stack[index - 1];
          index--;
          break;
        case "*":
          stack[index - 2] *= stack[index - 1];
          index--;
          break;
        case "/":
          stack[index - 2] /= stack[index - 1];
          index--;
          break;
        default:
          stack[index++] = Integer.parseInt(token);
      }
    }
    return stack[0];
  }
}
