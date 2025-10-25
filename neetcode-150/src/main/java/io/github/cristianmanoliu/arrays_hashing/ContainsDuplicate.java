package io.github.cristianmanoliu.arrays_hashing;

import java.util.HashSet;
import java.util.Set;

// https://neetcode.io/problems/duplicate-integer?list=neetcode150
// https://leetcode.com/problems/contains-duplicate
public class ContainsDuplicate {

  public boolean hasDuplicate(int[] nums) {
    Set<Integer> seen = new HashSet<>();
    for (int num : nums) {
      if (!seen.add(num)) {
        return true;
      }
    }
    return false;
  }
}
