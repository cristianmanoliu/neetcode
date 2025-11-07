package io.github.cristianmanoliu.binary_search;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FindMinimumInRotatedSortedArrayTest {

  @Test
  @DisplayName("Empty or null input -> IllegalArgumentException")
  void emptyOrNull() {
    assertThrows(IllegalArgumentException.class, () -> FindMinimumInRotatedSortedArray.findMin(new int[] {}));
    assertThrows(IllegalArgumentException.class, () -> FindMinimumInRotatedSortedArray.findMin(null));
  }

  @Test
  @DisplayName("Single element -> that element")
  void singleElement() {
    assertEquals(7, FindMinimumInRotatedSortedArray.findMin(new int[] {7}));
  }

  @Test
  @DisplayName("Already sorted (no rotation) -> first element")
  void alreadySorted() {
    assertEquals(1, FindMinimumInRotatedSortedArray.findMin(new int[] {1, 2, 3, 4}));
    assertEquals(-5, FindMinimumInRotatedSortedArray.findMin(new int[] {-5, -2, 0, 9}));
  }

  @Test
  @DisplayName("Classic rotations")
  void classicRotations() {
    assertEquals(1, FindMinimumInRotatedSortedArray.findMin(new int[] {3, 4, 5, 1, 2}));
    assertEquals(0, FindMinimumInRotatedSortedArray.findMin(new int[] {4, 5, 6, 7, 0, 1, 2}));
    assertEquals(1, FindMinimumInRotatedSortedArray.findMin(new int[] {2, 3, 4, 5, 1}));
  }

  @Test
  @DisplayName("Two elements (rotated/non-rotated)")
  void twoElements() {
    assertEquals(1, FindMinimumInRotatedSortedArray.findMin(new int[] {1, 2}));
    assertEquals(1, FindMinimumInRotatedSortedArray.findMin(new int[] {2, 1}));
  }

  @Test
  @DisplayName("Mixed negatives & positives")
  void mixedNegativesPositives() {
    // Sorted base [-1, 0, 3, 5] rotated -> [3, 5, -1, 0]
    assertEquals(-1, FindMinimumInRotatedSortedArray.findMin(new int[] {3, 5, -1, 0}));
    // Another rotation: [0, 3, 5, -1]
    assertEquals(-1, FindMinimumInRotatedSortedArray.findMin(new int[] {0, 3, 5, -1}));
  }

  @Test
  @DisplayName("Minimum at extreme indices")
  void minAtExtremes() {
    // Min at index 0 (already sorted handled above); here min at last after rotation
    assertEquals(1, FindMinimumInRotatedSortedArray.findMin(new int[] {2, 3, 4, 5, 1}));
    // Min near start
    assertEquals(2, FindMinimumInRotatedSortedArray.findMin(new int[] {2, 10, 12}));
  }
}
