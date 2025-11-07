package io.github.cristianmanoliu.binary_search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MedianOfTwoSortedArraysTest {

  private final MedianOfTwoSortedArrays sol = new MedianOfTwoSortedArrays();

  @Test
  @DisplayName("Odd total length: [1,3] & [2] -> 2.0")
  void oddTotal() {
    assertEquals(2.0, sol.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
  }

  @Test
  @DisplayName("Even total length: [1,2] & [3,4] -> 2.5")
  void evenTotal() {
    assertEquals(2.5, sol.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
  }

  @Test
  @DisplayName("One array empty")
  void oneEmpty() {
    assertEquals(1.0, sol.findMedianSortedArrays(new int[]{}, new int[]{1}));
    assertEquals(2.5, sol.findMedianSortedArrays(new int[]{}, new int[]{2, 3}));
  }

  @Test
  @DisplayName("Different sizes, general case")
  void differentSizesGeneral() {
    int[] A = {1, 3, 8, 9, 15};
    int[] B = {7, 11, 18, 19, 21, 25}; // merged -> ... median = 11.0
    assertEquals(11.0, sol.findMedianSortedArrays(A, B));
  }

  @Test
  @DisplayName("Negatives and ordering")
  void negatives() {
    assertEquals(-2.0, sol.findMedianSortedArrays(new int[]{-3, -1}, new int[]{-2}));
  }

  @Test
  @DisplayName("Duplicates across arrays")
  void duplicates() {
    assertEquals(2.0, sol.findMedianSortedArrays(new int[]{1, 2, 2}, new int[]{2, 2}));
  }

  @Test
  @DisplayName("Call with A longer than B (swap path)")
  void swapPath() {
    // A is longer; function should internally swap arrays
    assertEquals(3.0, sol.findMedianSortedArrays(new int[]{1, 2, 3, 4}, new int[]{5}));
    assertEquals(3.0, sol.findMedianSortedArrays(new int[]{1, 2, 3, 4}, new int[]{3}));
  }

  @Test
  @DisplayName("Large values around Integer limits - even sum safe via double cast")
  void nearIntegerLimits() {
    int[] A = {Integer.MAX_VALUE - 1};
    int[] B = {Integer.MAX_VALUE};
    // Average of the two large ints should be computed safely
    double expected = ((double) (Integer.MAX_VALUE - 1) + (double) Integer.MAX_VALUE) / 2.0;
    assertEquals(expected, sol.findMedianSortedArrays(A, B));
  }
}
