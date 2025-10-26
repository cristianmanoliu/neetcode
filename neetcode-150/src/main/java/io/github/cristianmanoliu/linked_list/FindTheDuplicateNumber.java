package io.github.cristianmanoliu.linked_list;

// https://neetcode.io/problems/find-duplicate-integer?list=neetcode150
// https://leetcode.com/problems/find-the-duplicate-number
public class FindTheDuplicateNumber {

  // Floyd's Tortoise & Hare (cycle detection) on index graph
  // Time: O(n), Space: O(1)
  public int findDuplicate(int[] nums) {
    // Phase 1: find meeting point inside the cycle
    int slow = nums[0];
    int fast = nums[nums[0]];
    while (slow != fast) {
      slow = nums[slow];
      fast = nums[nums[fast]];
    }

    // Phase 2: find cycle entrance (the duplicate number)
    slow = 0;
    while (slow != fast) {
      slow = nums[slow];
      fast = nums[fast];
    }
    return slow; // or fast
  }
}