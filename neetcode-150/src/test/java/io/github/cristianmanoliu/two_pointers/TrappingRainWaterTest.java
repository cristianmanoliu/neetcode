package io.github.cristianmanoliu.two_pointers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TrappingRainWaterTest {

  private final TrappingRainWater trappingRainWater = new TrappingRainWater();

  @Test
  void returnsNineForExampleInput() {
    /*
     * ⬜ ⬜ ⬜ ⬛ 🟦 🟦 🟦 ⬛ ⬜ ⬜
     * ⬜ ⬛ 🟦 ⬛ 🟦 🟦 🟦 ⬛ ⬛ ⬜
     * ⬜ ⬛ 🟦 ⬛ ⬛ 🟦 ⬛ ⬛ ⬛ ⬛
     */
    int[] height = {0, 2, 0, 3, 1, 0, 1, 3, 2, 1};
    int expected = 9;
    int result = trappingRainWater.trapTwoPointer(height);
    assertEquals(expected, result);
    result = trappingRainWater.trapPrefixSuffixMaxima(height);
    assertEquals(expected, result);
  }

  @Test
  void returnsSixForLeetcodeExample() {
    /*
     * ⬜ ⬜ ⬜ ⬜ ⬜ ⬜ ⬜ ⬛ ⬜ ⬜ ⬜ ⬜
     * ⬜ ⬜ ⬜ ⬛ 🟦 🟦 🟦 ⬛ ⬛ 🟦 ⬛ ⬜
     * ⬜ ⬛ 🟦 ⬛ ⬛ 🟦 ⬛ ⬛ ⬛ ⬛ ⬛ ⬛
     */
    int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    int expected = 6;
    int result = trappingRainWater.trapTwoPointer(height);
    assertEquals(expected, result);
    result = trappingRainWater.trapPrefixSuffixMaxima(height);
    assertEquals(expected, result);
  }
}