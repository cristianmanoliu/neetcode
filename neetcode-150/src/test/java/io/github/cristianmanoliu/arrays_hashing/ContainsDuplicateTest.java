package io.github.cristianmanoliu.arrays_hashing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ContainsDuplicateTest {

  @Test
  @DisplayName("Empty array has no duplicates")
  void emptyArray() {
    ContainsDuplicate sol = new ContainsDuplicate();
    assertFalse(sol.hasDuplicate(new int[]{}));
  }

  @Test
  @DisplayName("Single element has no duplicates")
  void singleElement() {
    ContainsDuplicate sol = new ContainsDuplicate();
    assertFalse(sol.hasDuplicate(new int[]{42}));
  }

  @Test
  @DisplayName("Two equal elements are a duplicate")
  void twoEqualElements() {
    ContainsDuplicate sol = new ContainsDuplicate();
    assertTrue(sol.hasDuplicate(new int[]{5, 5}));
  }

  @Test
  @DisplayName("All unique values -> false")
  void allUnique() {
    ContainsDuplicate sol = new ContainsDuplicate();
    assertFalse(sol.hasDuplicate(new int[]{1, 2, 3, 4, 5}));
  }

  @Test
  @DisplayName("Duplicate appears later in the array")
  void duplicateLater() {
    ContainsDuplicate sol = new ContainsDuplicate();
    assertTrue(sol.hasDuplicate(new int[]{1, 2, 3, 2}));
  }

  @Test
  @DisplayName("Handles negatives and zero")
  void negativesAndZero() {
    ContainsDuplicate sol = new ContainsDuplicate();
    assertFalse(sol.hasDuplicate(new int[]{-3, -2, -1, 0}));
    assertTrue(sol.hasDuplicate(new int[]{-1, 0, -1}));
  }
}