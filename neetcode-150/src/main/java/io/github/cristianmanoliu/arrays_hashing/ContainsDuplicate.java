package io.github.cristianmanoliu.arrays_hashing;

import java.util.HashSet;
import java.util.Set;

// https://neetcode.io/problems/duplicate-integer?list=neetcode150
// https://leetcode.com/problems/contains-duplicate
public class ContainsDuplicate {

  // Main function: return true if any value appears at least twice in the array.
  // Strategy: Scan once while inserting numbers into a HashSet.
  // - If add() returns false, the number was already present → duplicate found.
  public boolean hasDuplicate(int[] nums) {
    // Seen set to track numbers we've encountered
    Set<Integer> seen = new HashSet<>();

    // Traverse all numbers in the array
    for (int num : nums) {
      // If adding fails, 'num' is already in the set → duplicate
      if (!seen.add(num)) {
        return true;
      }
    }

    // No duplicates found after the full scan
    return false;
  }
}