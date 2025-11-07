package io.github.cristianmanoliu.arrays_hashing;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TwoSumTest {

  private final TwoSum sol = new TwoSum();

  @Test
  @DisplayName("Empty or too short input -> empty result")
  void emptyOrShort() {
    assertArrayEquals(new int[]{}, sol.twoSum(new int[]{}, 10));
    assertArrayEquals(new int[]{}, sol.twoSum(new int[]{5}, 5));
    assertArrayEquals(new int[]{}, sol.twoSum(null, 0));
  }

  @Test
  @DisplayName("Classic example: [2,7,11,15], target=9 -> [0,1]")
  void classic() {
    assertArrayEquals(new int[]{0, 1}, sol.twoSum(new int[]{2, 7, 11, 15}, 9));
  }

  @Test
  @DisplayName("Pair uses duplicates: [3,3], target=6 -> [0,1]")
  void duplicates() {
    assertArrayEquals(new int[]{0, 1}, sol.twoSum(new int[]{3, 3}, 6));
  }

  @Test
  @DisplayName("Works with negatives")
  void negatives() {
    assertArrayEquals(new int[]{0, 2}, sol.twoSum(new int[]{-3, 4, 3, 90}, 0));
  }

  @Test
  @DisplayName("Deterministic pair among multiple possibilities")
  void multiplePossibilities() {
    // For [1,2,3,4], target=6, the algorithm returns indices for (2,4) -> [1,3]
    assertArrayEquals(new int[]{1, 3}, sol.twoSum(new int[]{1, 2, 3, 4}, 6));
  }

  @Test
  @DisplayName("No solution -> empty array (defensive)")
  void noSolution() {
    assertArrayEquals(new int[]{}, sol.twoSum(new int[]{1, 2, 3}, 100));
  }
}
