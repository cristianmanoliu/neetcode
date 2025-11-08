package io.github.cristianmanoliu.bit_manipulation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SingleNumberTest {

  private final SingleNumber sol = new SingleNumber();

  @Test
  @DisplayName("LeetCode classic: [2,2,1] -> 1")
  void classic() {
    assertEquals(1, sol.singleNumber(new int[]{2, 2, 1}));
  }

  @Test
  @DisplayName("Mixed positives: [4,1,2,1,2] -> 4")
  void mixedPositives() {
    assertEquals(4, sol.singleNumber(new int[]{4, 1, 2, 1, 2}));
  }

  @Test
  @DisplayName("Includes zero: [0,1,0] -> 1")
  void includesZero() {
    assertEquals(1, sol.singleNumber(new int[]{0, 1, 0}));
  }

  @Test
  @DisplayName("Negative numbers supported: [-4,1,2,1,2] -> -4")
  void negatives() {
    assertEquals(-4, sol.singleNumber(new int[]{-4, 1, 2, 1, 2}));
  }

  @Test
  @DisplayName("Single element array returns that element")
  void singleElement() {
    assertEquals(99, sol.singleNumber(new int[]{99}));
  }

  @Test
  @DisplayName("Large values around Integer limits")
  void nearIntegerLimits() {
    int a = Integer.MAX_VALUE;
    int b = Integer.MIN_VALUE;
    // unique is a; b and b cancel, 0 and 0 cancel
    assertEquals(a, sol.singleNumber(new int[]{a, b, 0, b, 0}));
  }

  @Test
  @DisplayName("Defensive: null or empty throws IllegalArgumentException")
  void defensiveGuards() {
    assertThrows(IllegalArgumentException.class, () -> sol.singleNumber(null));
    assertThrows(IllegalArgumentException.class, () -> sol.singleNumber(new int[]{}));
  }
}