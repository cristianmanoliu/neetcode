package io.github.cristianmanoliu.arrays_hashing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LongestConsecutiveSequenceTest {

  private final LongestConsecutiveSequence sol = new LongestConsecutiveSequence();

  @Test
  @DisplayName("Empty array -> 0")
  void emptyArray() {
    assertEquals(0, sol.longestConsecutive(new int[] {}));
  }

  @Test
  @DisplayName("Single element -> 1")
  void singleElement() {
    assertEquals(1, sol.longestConsecutive(new int[] {7}));
  }

  @Test
  @DisplayName("LeetCode example: [100,4,200,1,3,2] -> 4")
  void leetcodeExample1() {
    assertEquals(4, sol.longestConsecutive(new int[] {100, 4, 200, 1, 3, 2}));
  }

  @Test
  @DisplayName("Another example: [0,3,7,2,5,8,4,6,0,1] -> 9")
  void leetcodeExample2() {
    assertEquals(9, sol.longestConsecutive(new int[] {0,3,7,2,5,8,4,6,0,1}));
  }

  @Test
  @DisplayName("Handles duplicates correctly")
  void withDuplicates() {
    // Longest consecutive is [1,2,3] -> length 3
    assertEquals(3, sol.longestConsecutive(new int[] {1, 2, 2, 3}));
  }

  @Test
  @DisplayName("Negatives and positives mixed")
  void negativesMixed() {
    // Longest consecutive among [-3,-2,-1,7] is [-3,-2,-1] -> length 3
    assertEquals(3, sol.longestConsecutive(new int[] {-1, -2, 7, -3}));
  }

  @Test
  @DisplayName("All equal numbers -> 1")
  void allEqual() {
    assertEquals(1, sol.longestConsecutive(new int[] {5, 5, 5, 5}));
  }

  @Test
  @DisplayName("Long chain unsorted -> full length")
  void longChain() {
    // Contains 1..10 -> length 10
    assertEquals(10, sol.longestConsecutive(new int[] {9,1,3,10,2,20,4,5,7,8,6}));
  }

  @Test
  @DisplayName("Boundary values near Integer.MIN_VALUE")
  void boundaryMinValue() {
    // Sequence MIN_VALUE, MIN_VALUE+1 -> length 2
    assertEquals(2, sol.longestConsecutive(new int[] {Integer.MIN_VALUE + 1, Integer.MIN_VALUE}));
  }
}