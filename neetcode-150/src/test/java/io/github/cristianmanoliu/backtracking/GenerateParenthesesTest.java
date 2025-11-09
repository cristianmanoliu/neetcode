package io.github.cristianmanoliu.backtracking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GenerateParenthesesTest {

  @Test
  @DisplayName("Negative n throws IllegalArgumentException")
  void negativeNThrows() {
    GenerateParentheses sol = new GenerateParentheses();
    assertThrows(IllegalArgumentException.class, () -> sol.generateParenthesis(-1));
  }

  @Test
  @DisplayName("n = 0 -> single empty string")
  void zeroPairs() {
    GenerateParentheses sol = new GenerateParentheses();
    List<String> result = sol.generateParenthesis(0);

    assertEquals(1, result.size());
    assertTrue(result.contains("")); // only the empty sequence
  }

  @Test
  @DisplayName("n = 1 -> single pair ()")
  void onePair() {
    GenerateParentheses sol = new GenerateParentheses();
    List<String> result = sol.generateParenthesis(1);

    assertEquals(1, result.size());
    assertTrue(result.contains("()"));
  }

  @Test
  @DisplayName("n = 2 -> two valid combinations: (()) and ()()")
  void twoPairs() {
    GenerateParentheses sol = new GenerateParentheses();
    List<String> result = sol.generateParenthesis(2);

    // There should be exactly 2 combinations.
    assertEquals(2, result.size());
    assertTrue(result.contains("(())"));
    assertTrue(result.contains("()()"));
  }

  @Test
  @DisplayName("n = 3 -> five valid combinations (Catalan number C3 = 5)")
  void threePairs() {
    GenerateParentheses sol = new GenerateParentheses();
    List<String> result = sol.generateParenthesis(3);

    // Catalan C3 = 5
    assertEquals(5, result.size());

    // Canonical 3-pair sequences.
    assertTrue(result.contains("((()))"));
    assertTrue(result.contains("(()())"));
    assertTrue(result.contains("(())()"));
    assertTrue(result.contains("()(())"));
    assertTrue(result.contains("()()()"));
  }
}
