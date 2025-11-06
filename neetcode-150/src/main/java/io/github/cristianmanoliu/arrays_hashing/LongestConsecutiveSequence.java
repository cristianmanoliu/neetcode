package io.github.cristianmanoliu.arrays_hashing;

import java.util.HashSet;
import java.util.Set;

// https://neetcode.io/problems/longest-consecutive-sequence?list=neetcode150
// https://leetcode.com/problems/longest-consecutive-sequence
public class LongestConsecutiveSequence {

  // Main function: return the length of the longest consecutive integer sequence in nums.
  // Strategy:
  // 1) Insert all numbers into a HashSet for O(1) membership checks.
  // 2) A number 'num' starts a sequence iff (num - 1) is NOT in the set.
  // 3) When we find a start, walk upward (num + 1, num + 2, ...) counting the streak length.
  public int longestConsecutive(int[] nums) {
    // Build a set of all unique numbers
    Set<Integer> numSet = new HashSet<>();
    for (int num : nums) {
      numSet.add(num);
    }

    // Tracks the best (maximum) streak found so far
    int longestStreak = 0;

    // Iterate over unique numbers only (via the set)
    for (int num : numSet) {
      // Only attempt to grow a sequence if 'num' is the START of one
      // i.e., there is no predecessor (num - 1) in the set
      if (!numSet.contains(num - 1)) {
        int currentNum = num;   // current value while walking the sequence
        int currentStreak = 1;  // we have at least 'num' itself

        // Walk forward while consecutive successors exist
        while (numSet.contains(currentNum + 1)) {
          currentNum++;
          currentStreak++;
        }

        // Update the best streak length
        longestStreak = Math.max(longestStreak, currentStreak);
      }
    }

    // Return the longest sequence length discovered
    return longestStreak;
  }
}