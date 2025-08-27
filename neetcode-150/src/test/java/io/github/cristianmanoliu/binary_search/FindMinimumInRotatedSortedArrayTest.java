package io.github.cristianmanoliu.binary_search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FindMinimumInRotatedSortedArrayTest {

  private final FindMinimumInRotatedSortedArray findMinimum = new FindMinimumInRotatedSortedArray();

  @Test
  void example1_findMin_returns1() {
    int[] nums = {3, 4, 5, 6, 1, 2};
    int expected = 1;
    int result = findMinimum.findMin(nums);
    assertEquals(expected, result);
  }

  @Test
  void example2_findMin_returns0() {
    int[] nums = {4, 5, 0, 1, 2, 3};
    int expected = 0;
    int result = findMinimum.findMin(nums);
    assertEquals(expected, result);
  }

  @Test
  void example3_findMin_returns4() {
    int[] nums = {4, 5, 6, 7};
    int expected = 4;
    int result = findMinimum.findMin(nums);
    assertEquals(expected, result);
  }
}