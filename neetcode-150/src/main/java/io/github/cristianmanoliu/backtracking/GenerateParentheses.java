package io.github.cristianmanoliu.backtracking;

import java.util.ArrayList;
import java.util.List;

// https://neetcode.io/problems/generate-parentheses?list=neetcode150
// https://leetcode.com/problems/generate-parentheses
public class GenerateParentheses {

  // Generate all combinations of n pairs of valid parentheses.
  //
  // Backtracking idea:
  // - Build the string one character at a time in a StringBuilder.
  // - Track how many '(' (openCount) and ')' (closeCount) we have used.
  // - At any point:
  //   * We can add '(' if openCount < n.
  //   * We can add ')' if closeCount < openCount (to keep the prefix valid).
  // - When the current length reaches 2 * n, we have a complete valid sequence.
  public List<String> generateParenthesis(int n) {
    if (n < 0) {
      throw new IllegalArgumentException("n must be non-negative");
    }

    List<String> result = new ArrayList<>();

    // Start backtracking with an empty builder and zero counts.
    backtrack(result, new StringBuilder(), 0, 0, n);
    return result;
  }

  // Backtracking helper:
  // - result: collector for all valid parenthesis strings
  // - current: the partial string we are currently building
  // - openCount: how many '(' we've added so far
  // - closeCount: how many ')' we've added so far
  // - n: total number of pairs to generate
  private void backtrack(List<String> result, StringBuilder current,
      int openCount, int closeCount, int n) {

    // Base case: if we've used all n pairs (string length = 2 * n),
    // we have a complete valid combination.
    if (current.length() == 2 * n) {
      result.add(current.toString());
      return;
    }

    // Choice 1: add an opening parenthesis if we still have some left.
    if (openCount < n) {
      current.append('('); // choose '('
      backtrack(result, current, openCount + 1, closeCount, n);
      current.deleteCharAt(current.length() - 1);  // undo choice (backtrack)
    }

    // Choice 2: add a closing parenthesis if it keeps the string valid,
    // i.e., we cannot close more than we've opened.
    if (closeCount < openCount) {
      current.append(')'); // choose ')'
      backtrack(result, current, openCount, closeCount + 1, n);
      current.deleteCharAt(current.length() - 1);  // undo choice (backtrack)
    }
  }
}