package io.github.cristianmanoliu.two_pointers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class TwoIntegerSumIITest {

  private final TwoIntegerSumII twoIntegerSumII = new TwoIntegerSumII();

  @Test
  void returnsIndicesOneAndTwoForTargetThree() {
    int[] numbers = {1, 2, 3, 4};
    int target = 3;
    int[] expected = {1, 2};
    int[] result = twoIntegerSumII.twoSum(numbers, target);
    assertArrayEquals(expected, result);
  }
}