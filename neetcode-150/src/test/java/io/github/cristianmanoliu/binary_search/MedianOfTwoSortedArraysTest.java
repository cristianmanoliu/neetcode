package io.github.cristianmanoliu.binary_search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MedianOfTwoSortedArraysTest {

  @Test
  void example1() {
    MedianOfTwoSortedArrays solver = new MedianOfTwoSortedArrays();
    double result = solver.findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
    assertEquals(2.0, result, 1e-6);
  }

  @Test
  void example2() {
    MedianOfTwoSortedArrays solver = new MedianOfTwoSortedArrays();
    double result = solver.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
    assertEquals(2.5, result, 1e-6);
  }
}