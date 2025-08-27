package io.github.cristianmanoliu.binary_search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SearchInRotatedSortedArrayTest {

  private final SearchInRotatedSortedArray searcher = new SearchInRotatedSortedArray();

  @Test
  void example1_search_returns4() {
    int[] nums = {3, 4, 5, 6, 1, 2};
    int target = 1;
    int expected = 4;
    int result = searcher.search(nums, target);
    assertEquals(expected, result);
  }

  @Test
  void example2_search_returnsMinus1() {
    int[] nums = {3, 5, 6, 0, 1, 2};
    int target = 4;
    int expected = -1;
    int result = searcher.search(nums, target);
    assertEquals(expected, result);
  }
}