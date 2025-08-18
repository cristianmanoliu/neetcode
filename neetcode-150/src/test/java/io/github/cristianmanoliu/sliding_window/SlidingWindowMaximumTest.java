package io.github.cristianmanoliu.sliding_window;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SlidingWindowMaximumTest {

  private final SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();

  @Test
  void example1_maxSlidingWindow_returnsExpected() {
    int[] nums = {1, 2, 1, 0, 4, 2, 6};
    int k = 3;
    int[] expected = {2, 2, 4, 4, 6};
    int[] result = slidingWindowMaximum.maxSlidingWindow(nums, k);
    assertArrayEquals(expected, result);
  }
}