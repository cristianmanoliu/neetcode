package io.github.cristianmanoliu.arrays_hashing;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class TwoSumTest {

  private final TwoSum twoSum = new TwoSum();

  @Test
  void testExample1() {
    int[] result = twoSum.twoSum(new int[]{3, 4, 5, 6}, 7);
    assertArrayEquals(new int[]{0, 1}, result);
  }

  @Test
  void testExample2() {
    int[] result = twoSum.twoSum(new int[]{4, 5, 6}, 10);
    assertArrayEquals(new int[]{0, 2}, result);
  }

  @Test
  void testExample3() {
    int[] result = twoSum.twoSum(new int[]{5, 5}, 10);
    assertArrayEquals(new int[]{0, 1}, result);
  }
}