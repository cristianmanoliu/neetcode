package io.github.cristianmanoliu.sliding_window;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PermutationInStringTest {

  private final PermutationInString permutationInString = new PermutationInString();

  @Test
  void example1_checkInclusion_returnsTrue() {
    String s1 = "abc";
    String s2 = "lecabee";
    boolean result = permutationInString.checkInclusion(s1, s2);
    assertTrue(result);
  }

  @Test
  void example2_checkInclusion_returnsFalse() {
    String s1 = "abc";
    String s2 = "lecaabee";
    boolean result = permutationInString.checkInclusion(s1, s2);
    assertFalse(result);
  }
}