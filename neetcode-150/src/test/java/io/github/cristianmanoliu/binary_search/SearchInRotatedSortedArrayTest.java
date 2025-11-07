package io.github.cristianmanoliu.binary_search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// JUnit 5 tests for SearchInRotatedSortedArray
class SearchInRotatedSortedArrayTest {

  private final SearchInRotatedSortedArray sol = new SearchInRotatedSortedArray();

  @Test
  @DisplayName("Empty array -> -1")
  void emptyArray() {
    assertEquals(-1, sol.search(new int[] {}, 5));
  }

  @Test
  @DisplayName("Single element present/absent")
  void singleElement() {
    assertEquals(0, sol.search(new int[] {7}, 7));
    assertEquals(-1, sol.search(new int[] {7}, 8));
  }

  @Test
  @DisplayName("LeetCode classic: [4,5,6,7,0,1,2]")
  void leetcodeClassic() {
    int[] a = {4,5,6,7,0,1,2};
    assertEquals(4, sol.search(a, 0));  // pivot element
    assertEquals(-1, sol.search(a, 3)); // not present
  }

  @Test
  @DisplayName("No rotation behaves like normal binary search")
  void noRotation() {
    int[] a = {1,2,3,4,5};
    assertEquals(2, sol.search(a, 3));
    assertEquals(-1, sol.search(a, 6));
  }

  @Test
  @DisplayName("Two elements rotated/non-rotated")
  void twoElements() {
    assertEquals(1, sol.search(new int[] {3,1}, 1));
    assertEquals(0, sol.search(new int[] {3,1}, 3));
    assertEquals(-1, sol.search(new int[] {3,1}, 2));
  }

  @Test
  @DisplayName("Target at ends")
  void targetAtEnds() {
    int[] a = {6,7,8,1,2,3,4,5};
    assertEquals(0, sol.search(a, 6)); // first
    assertEquals(7, sol.search(a, 5)); // last
  }

  @Test
  @DisplayName("Negatives and positives mixed")
  void negativesMixed() {
    int[] a = {0,1,2,-4,-3,-2};
    assertEquals(4, sol.search(a, -3));
    assertEquals(-1, sol.search(a, 10));
  }
}