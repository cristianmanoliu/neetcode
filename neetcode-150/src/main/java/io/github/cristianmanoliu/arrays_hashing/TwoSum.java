package io.github.cristianmanoliu.arrays_hashing;

import java.util.HashMap;
import java.util.Map;

// https://neetcode.io/problems/two-integer-sum?list=neetcode150
// https://leetcode.com/problems/two-sum/
public class TwoSum {

  // Main function: return indices [i, j] such that nums[i] + nums[j] == target (i < j).
  // Strategy: One-pass HashMap from number -> its index.
  // For each element nums[i], check if its complement (target - nums[i]) is already in the map.
  // If yes, we found a valid pair; otherwise put nums[i] in the map and continue.
  public int[] twoSum(int[] nums, int target) {
    // Edge case: null or too short -> no pair possible
    if (nums == null || nums.length < 2) {
      return new int[]{};
    }

    // Map to remember the index where each number was first seen
    Map<Integer, Integer> indexByValue = new HashMap<>();

    // Scan the array once
    for (int i = 0; i < nums.length; i++) {
      // Complement needed to reach 'target'
      int need = target - nums[i];

      // If we've seen 'need' before, we have our pair
      if (indexByValue.containsKey(need)) {
        return new int[]{indexByValue.get(need), i};
      }

      // Otherwise remember current number's index (only if not present, but overwrite is fine)
      indexByValue.put(nums[i], i);
    }

    // If problem guarantees a solution, we won't reach here; return empty for safety
    return new int[]{};
  }
}
