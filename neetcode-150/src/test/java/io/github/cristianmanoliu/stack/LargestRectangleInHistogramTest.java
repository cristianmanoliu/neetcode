package io.github.cristianmanoliu.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LargestRectangleInHistogramTest {

  private final LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();

  @Test
  void example1_largestRectangleArea_returns8() {
    int[] heights = {7, 1, 7, 2, 2, 4};
    int expected = 8;
    int result = largestRectangleInHistogram.largestRectangleArea(heights);
    assertEquals(expected, result);
  }

  @Test
  void example2_largestRectangleArea_returns7() {
    int[] heights = {1, 3, 7};
    int expected = 7;
    int result = largestRectangleInHistogram.largestRectangleArea(heights);
    assertEquals(expected, result);
  }
}