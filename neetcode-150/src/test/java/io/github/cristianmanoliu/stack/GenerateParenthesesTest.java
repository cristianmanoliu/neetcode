package io.github.cristianmanoliu.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class GenerateParenthesesTest {

  @Test
  void generateParenthesis() {
    GenerateParentheses gp = new GenerateParentheses();
    var result = gp.generateParenthesis(3);
    assertEquals(5, result.size());
    assertTrue(result.contains("((()))"));
    assertTrue(result.contains("(()())"));
    assertTrue(result.contains("(())()"));
    assertTrue(result.contains("()(())"));
    assertTrue(result.contains("()()()"));
  }

}