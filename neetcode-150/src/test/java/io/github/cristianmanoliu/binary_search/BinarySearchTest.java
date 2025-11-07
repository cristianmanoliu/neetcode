package io.github.cristianmanoliu.binary_search;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BinarySearchTest {

  private final BinarySearch sol = new BinarySearch();

  @Test
  @DisplayName("Empty array -> -1")
  void emptyArray() {
    assertEquals(-1, sol.search(new int[]{}, 5));
  }

  @Test
  @DisplayName("Single element present/absent")
  void singleElement() {
    assertEquals(0, sol.search(new int[]{7}, 7));
    assertEquals(-1, sol.search(new int[]{7}, 8));
  }

  @Test
  @DisplayName("LeetCode example: [-1,0,3,5,9,12]")
  void leetcodeExample() {
    int[] nums = {-1, 0, 3, 5, 9, 12};
    assertEquals(4, sol.search(nums, 9));
    assertEquals(-1, sol.search(nums, 2));
  }

  @Test
  @DisplayName("First and last element")
  void boundaries() {
    int[] nums = {2, 4, 6, 8, 10};
    assertEquals(0, sol.search(nums, 2));   // first
    assertEquals(4, sol.search(nums, 10));  // last
  }

  @Test
  @DisplayName("Handles negatives and mixed values")
  void negativesMixed() {
    int[] nums = {-10, -3, 0, 1, 4, 8};
    assertEquals(1, sol.search(nums, -3));
    assertEquals(2, sol.search(nums, 0));
    assertEquals(-1, sol.search(nums, 7));
  }

  @Test
  @DisplayName("Duplicates: any index of target is acceptable")
  void duplicatesAnyIndex() {
    int[] nums = {1, 1, 1, 2, 2, 3};
    int idx1 = sol.search(nums, 1);
    int idx2 = sol.search(nums, 2);
    assertTrue(idx1 >= 0 && nums[idx1] == 1);
    assertTrue(idx2 >= 0 && nums[idx2] == 2);
  }
}
