package io.github.cristianmanoliu.backtracking;

import java.util.ArrayList;
import java.util.List;

// https://neetcode.io/problems/subsets?list=neetcode150
// https://leetcode.com/problems/subsets/
public class Subsets {

  // Return all possible subsets (the power set) of the given array of distinct integers.
  //
  // Backtracking idea:
  // - Think of each element as a binary choice: either we include it in the subset or we don't.
  // - We explore all choices by:
  //   * maintaining a 'current' subset,
  //   * and an index 'start' that tells us which positions we can still consider.
  // - At every recursion level, we:
  //   * record the current subset as one valid answer,
  //   * then try to extend it by adding each remaining element in turn.
  public List<List<Integer>> subsets(int[] nums) {
    if (nums == null) {
      throw new IllegalArgumentException("nums must not be null");
    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> current = new ArrayList<>();

    // Start building subsets from index 0 with an empty 'current' subset.
    backtrack(nums, 0, current, result);
    return result;
  }

  // Backtracking helper:
  // - nums: original array
  // - start: next index we are allowed to choose from
  // - current: the subset we are currently building
  // - result: collector for all subsets
  private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
    // Every prefix of choices is itself a valid subset -> record a copy.
    result.add(new ArrayList<>(current));

    // Try to include each number from 'start' onward.
    for (int i = start; i < nums.length; i++) {
      // Choose nums[i]
      current.add(nums[i]);

      // Recurse with next index; we ensure each element is used at most once.
      backtrack(nums, i + 1, current, result);

      // Undo the choice (backtrack) to explore other subsets without nums[i].
      current.remove(current.size() - 1);
    }
  }
}