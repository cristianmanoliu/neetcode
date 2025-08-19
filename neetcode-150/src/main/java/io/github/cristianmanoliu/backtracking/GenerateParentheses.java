package io.github.cristianmanoliu.backtracking;

import java.util.ArrayList;
import java.util.List;

// https://neetcode.io/problems/generate-parentheses?list=neetcode150
public class GenerateParentheses {

  public List<String> generateParenthesis(int n) {
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder(2 * n);
    backtrack(n, 0, 0, sb, res);
    return res;
  }

  // n = target pairs; open/close = counts used so far
  private static void backtrack(int n, int open, int close, StringBuilder sb, List<String> res) {
    if (open == n && close == n) {
      res.add(sb.toString());
      return;
    }
    // Try adding '(' if we still have room
    if (open < n) {
      sb.append('(');
      backtrack(n, open + 1, close, sb, res);
      sb.deleteCharAt(sb.length() - 1); // undo
    }
    // Try adding ')' only if it keeps prefixes valid
    if (close < open) {
      sb.append(')');
      backtrack(n, open, close + 1, sb, res);
      sb.deleteCharAt(sb.length() - 1); // undo
    }
  }
}
