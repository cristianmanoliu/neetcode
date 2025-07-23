package io.github.cristianmanoliu.arrays_hashing;

import java.util.HashSet;
import java.util.Set;

// https://neetcode.io/problems/duplicate-integer?list=neetcode150
public class ContainsDuplicate {

  public boolean hasDuplicate(int[] nums) {
    if (nums == null || nums.length == 0) {
      return false;
    }

    boolean hasDuplicate = false;
    Set<Integer> unique = new HashSet<>();

    for (int number : nums) {
      if (unique.contains(number)) {
        hasDuplicate = true;
        break;
      } else {
        unique.add(number);
      }
    }

    return hasDuplicate;
  }
}
