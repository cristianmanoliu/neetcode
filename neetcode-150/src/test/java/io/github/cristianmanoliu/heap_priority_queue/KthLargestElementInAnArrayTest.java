package io.github.cristianmanoliu.heap_priority_queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class KthLargestElementInAnArrayTest {

  @Test
  @DisplayName("LeetCode example: [3,2,1,5,6,4], k=2 -> 5")
  void exampleOne() {
    KthLargestElementInAnArray solver = new KthLargestElementInAnArray();
    int[] nums = {3, 2, 1, 5, 6, 4};
    assertEquals(5, solver.findKthLargest(nums, 2));
  }

  @Test
  @DisplayName("LeetCode example: [3,2,3,1,2,4,5,5,6], k=4 -> 4")
  void exampleTwo() {
    KthLargestElementInAnArray solver = new KthLargestElementInAnArray();
    int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
    assertEquals(4, solver.findKthLargest(nums, 4));
  }

  @Test
  @DisplayName("k = 1 returns the maximum element")
  void kIsOneReturnsMax() {
    KthLargestElementInAnArray solver = new KthLargestElementInAnArray();
    int[] nums = {7, 1, 5, 9, 2};
    assertEquals(9, solver.findKthLargest(nums, 1));
  }

  @Test
  @DisplayName("k = n returns the minimum element")
  void kIsNReturnsMin() {
    KthLargestElementInAnArray solver = new KthLargestElementInAnArray();
    int[] nums = {7, 1, 5, 9, 2};
    assertEquals(1, solver.findKthLargest(nums, nums.length));
  }

  @Test
  @DisplayName("Handles duplicates and negative numbers")
  void duplicatesAndNegatives() {
    KthLargestElementInAnArray solver = new KthLargestElementInAnArray();
    int[] nums = {-1, -1, -2, 0, 3, 3};

    // Sorted descending: [3, 3, 0, -1, -1, -2]
    assertEquals(3, solver.findKthLargest(nums, 1)); // largest
    assertEquals(3, solver.findKthLargest(nums, 2)); // 2nd largest
    assertEquals(0, solver.findKthLargest(nums, 3)); // 3rd largest
    assertEquals(-1, solver.findKthLargest(nums, 4)); // 4th largest
  }

  @Test
  @DisplayName("Already sorted ascending still works")
  void sortedAscending() {
    KthLargestElementInAnArray solver = new KthLargestElementInAnArray();
    int[] nums = {1, 2, 3, 4, 5};
    assertEquals(4, solver.findKthLargest(nums, 2)); // 2nd largest
    assertEquals(2, solver.findKthLargest(nums, 4)); // 4th largest
  }

  @Test
  @DisplayName("Already sorted descending still works")
  void sortedDescending() {
    KthLargestElementInAnArray solver = new KthLargestElementInAnArray();
    int[] nums = {10, 8, 6, 4, 2};
    assertEquals(10, solver.findKthLargest(nums, 1));
    assertEquals(2, solver.findKthLargest(nums, nums.length));
  }

  @Test
  @DisplayName("Invalid k or null array throws IllegalArgumentException")
  void invalidArguments() {
    KthLargestElementInAnArray solver = new KthLargestElementInAnArray();

    assertThrows(IllegalArgumentException.class,
        () -> solver.findKthLargest(null, 1));

    assertThrows(IllegalArgumentException.class,
        () -> solver.findKthLargest(new int[]{1, 2, 3}, 0));

    assertThrows(IllegalArgumentException.class,
        () -> solver.findKthLargest(new int[]{1, 2, 3}, 4));
  }
}
