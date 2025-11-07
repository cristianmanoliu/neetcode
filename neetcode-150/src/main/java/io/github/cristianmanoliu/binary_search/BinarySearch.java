package io.github.cristianmanoliu.binary_search;

// https://neetcode.io/problems/binary-search?list=neetcode150
// https://leetcode.com/problems/binary-search/
public class BinarySearch {

  // Main function: search for 'target' in sorted ascending array 'nums'.
  // Strategy: Classic iterative binary search with two pointers [left, right].
  // - Compute mid safely as left + (right - left) / 2.
  // - If nums[mid] == target -> return mid.
  // - If nums[mid] < target  -> search right half (left = mid + 1).
  // - Else                   -> search left half  (right = mid - 1).
  // If the loop ends, target does not exist -> return -1.
  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    // Loop invariant: if target exists, it must lie within [left, right]
    while (left <= right) {
      // Midpoint; avoids potential overflow of (left + right)
      int mid = left + (right - left) / 2;

      // Found target
      if (nums[mid] == target) {
        return mid;
      }
      // Target is larger -> discard left half
      else if (nums[mid] < target) {
        left = mid + 1;
      }
      // Target is smaller -> discard right half
      else {
        right = mid - 1;
      }
    }

    // Target not found
    return -1;
  }
}
