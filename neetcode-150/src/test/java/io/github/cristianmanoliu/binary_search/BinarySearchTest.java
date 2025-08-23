package io.github.cristianmanoliu.binary_search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BinarySearchTest {

  private final BinarySearch binarySearch = new BinarySearch();

  @Test
  void example1_search_returns3() {
    int[] nums = {-1, 0, 2, 4, 6, 8};
    int target = 4;
    int expected = 3;
    int result = binarySearch.search(nums, target);
    assertEquals(expected, result);
  }

  @Test
  void example2_search_returnsMinus1() {
    int[] nums = {-1, 0, 2, 4, 6, 8};
    int target = 3;
    int expected = -1;
    int result = binarySearch.search(nums, target);
    assertEquals(expected, result);
  }
}