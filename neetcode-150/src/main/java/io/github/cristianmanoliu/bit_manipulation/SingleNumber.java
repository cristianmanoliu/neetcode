package io.github.cristianmanoliu.bit_manipulation;

// https://neetcode.io/problems/single-number?list=neetcode150
// https://leetcode.com/problems/single-number

public class SingleNumber {

  // Main function: return the element that appears exactly once;
  // all other elements appear exactly twice.
  // Strategy: XOR-fold the entire array; duplicates cancel out.
  // Base cases: The problem guarantees non-empty input.
  // Defensively, we throw for null/empty to avoid undefined behavior.
  public int singleNumber(int[] nums) {
    // Defensive guard (not required by LeetCode constraints, but safer in general use)
    if (nums == null || nums.length == 0) {
      throw new IllegalArgumentException("nums must be non-null and non-empty");
    }

    int res = 0;                 // Start with identity for XOR
    for (int v : nums) {         // Traverse all numbers
      res ^= v;                  // Accumulate via XOR; pairs cancel
    }
    return res;                  // Remaining value is the unique element
  }
}
