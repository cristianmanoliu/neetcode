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

  private static void backtrack(int n, int open, int close, StringBuilder sb, List<String> res) {
    // Completeness predicate
    if (open == n && close == n) {
      res.add(sb.toString());
      return;
    }
    // Feasibility predicate
    if (open < n) {
      // Branch generator
      sb.append('(');
      backtrack(n, open + 1, close, sb, res);
      sb.deleteCharAt(sb.length() - 1);
    }
    // Feasibility predicate
    if (close < open) {
      // Branch generator
      sb.append(')');
      backtrack(n, open, close + 1, sb, res);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}
