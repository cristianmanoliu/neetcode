package io.github.cristianmanoliu.bit_manipulation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// JUnit 5 tests for CountingBits
class CountingBitsTest {

  private final CountingBits sol = new CountingBits();

  @Test
  @DisplayName("n = 0 -> [0]")
  void nZero() {
    assertArrayEquals(new int[]{0}, sol.countBits(0));
  }

  @Test
  @DisplayName("Small n examples")
  void smallExamples() {
    assertArrayEquals(new int[]{0, 1}, sol.countBits(1));
    assertArrayEquals(new int[]{0, 1, 1}, sol.countBits(2));
    assertArrayEquals(new int[]{0, 1, 1, 2, 1, 2}, sol.countBits(5));
  }

  @Test
  @DisplayName("Powers of two have exactly one set bit")
  void powersOfTwo() {
    int n = 16;
    int[] dp = sol.countBits(n);
    assertEquals(1, dp[1]);
    assertEquals(1, dp[2]);
    assertEquals(1, dp[4]);
    assertEquals(1, dp[8]);
    assertEquals(1, dp[16]);
  }

  @Test
  @DisplayName("Spot-check mixed values")
  void spotChecks() {
    int[] dp = sol.countBits(13);
    // 7 (0b0111) -> 3, 8 (1000) -> 1, 9 (1001) -> 2, 13 (1101) -> 3
    assertEquals(3, dp[7]);
    assertEquals(1, dp[8]);
    assertEquals(2, dp[9]);
    assertEquals(3, dp[13]);
  }

  @Test
  @DisplayName("Compare against Integer.bitCount for a moderate n")
  void compareAgainstLibrary() {
    int n = 1000;
    int[] dp = sol.countBits(n);
    for (int i = 0; i <= n; i++) {
      assertEquals(Integer.bitCount(i), dp[i], "Mismatch at i=" + i);
    }
  }
}
