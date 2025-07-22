package io.github.cristianmanoliu.arrays_hashing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LongestConsecutiveSequenceTest {

  private final LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();

  @Test
  void returnsFourForSequenceTwoToFive() {
    int[] nums = {2, 20, 4, 10, 3, 4, 5};
    int result = longestConsecutiveSequence.longestConsecutive(nums);
    assertEquals(4, result);
  }

  @Test
  void returnsSevenForSequenceZeroToSixWithDuplicates() {
    int[] nums = {0, 3, 2, 5, 4, 6, 1, 1};
    int result = longestConsecutiveSequence.longestConsecutive(nums);
    assertEquals(7, result);
  }
}