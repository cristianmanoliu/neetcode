package io.github.cristianmanoliu.stack;

import java.util.Stack;

// https://neetcode.io/problems/validate-parentheses?list=neetcode150
// https://leetcode.com/problems/valid-parentheses/
public class ValidParentheses {

  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();

    for (char c : s.toCharArray()) {
      // If opening bracket, push to stack
      if (c == '(' || c == '{' || c == '[') {
        stack.push(c);
      }
      // If closing bracket, check for matching opening bracket
      else if (c == ')' || c == '}' || c == ']') {
        // Stack must be non-empty
        if (stack.isEmpty()) {
          return false;
        }

        char top = stack.pop();

        // Check if brackets match
        if (c == ')' && top != '(') {
          return false;
        }
        if (c == '}' && top != '{') {
          return false;
        }
        if (c == ']' && top != '[') {
          return false;
        }
      }
    }

    // All brackets must be matched (stack empty)
    return stack.isEmpty();
  }
}
