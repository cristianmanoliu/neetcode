package io.github.cristianmanoliu.stack;

import java.util.ArrayList;
import java.util.List;

// https://neetcode.io/problems/generate-parentheses?list=neetcode150
// https://leetcode.com/problems/generate-parentheses
public class GenerateParentheses {

  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    backtrack(result, new StringBuilder(), 0, 0, n);
    return result;
  }

  private void backtrack(List<String> result, StringBuilder current,
      int openCount, int closeCount, int n) {
    // Base case: if we've used all n pairs
    if (current.length() == 2 * n) {
      result.add(current.toString());
      return;
    }

    // Add opening parenthesis if we haven't used all n
    if (openCount < n) {
      current.append('(');
      backtrack(result, current, openCount + 1, closeCount, n);
      current.deleteCharAt(current.length() - 1);  // Backtrack
    }

    // Add closing parenthesis if it would be valid
    if (closeCount < openCount) {
      current.append(')');
      backtrack(result, current, openCount, closeCount + 1, n);
      current.deleteCharAt(current.length() - 1);  // Backtrack
    }
  }
}
