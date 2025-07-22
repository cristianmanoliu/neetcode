package io.github.cristianmanoliu.arrays_hashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

  public int longestConsecutive(int[] nums) {
    Set<Integer> numSet = new HashSet<>();
    for (int num : nums) {
      numSet.add(num);
    }

    int longestStreak = 0;
    for (int num : nums) {
      // Only check for the start of a sequence
      if (!numSet.contains(num - 1)) {
        int currentNum = num;
        int currentStreak = 1;

        // Count the length of the sequence
        while (numSet.contains(currentNum + 1)) {
          currentNum++;
          currentStreak++;
        }

        longestStreak = Math.max(longestStreak, currentStreak);
      }
    }
    return longestStreak;
  }
}