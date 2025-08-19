package io.github.cristianmanoliu.backtracking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GenerateParenthesesTest {

  private final GenerateParentheses generateParentheses = new GenerateParentheses();

  @Test
  public void example1() {
    var result = generateParentheses.generateParenthesis(1);
    assertEquals(1, result.size());
    assertTrue(result.contains("()"));
  }

  @Test
  public void example2() {
    var result = generateParentheses.generateParenthesis(3);
    assertEquals(5, result.size());
    assertTrue(result.contains("((()))"));
    assertTrue(result.contains("(()())"));
    assertTrue(result.contains("(())()"));
    assertTrue(result.contains("(())()"));
    assertTrue(result.contains("()()()"));
  }
}