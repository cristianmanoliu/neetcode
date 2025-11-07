package io.github.cristianmanoliu.binary_search;

// https://neetcode.io/problems/find-minimum-in-rotated-sorted-array?list=neetcode150
// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class FindMinimumInRotatedSortedArray {

  // Main function: find the minimum element in a rotated sorted array (no duplicates).
  // Strategy: Binary search on the pivot using the right boundary as the comparator.
  // - If nums[mid] > nums[right], the minimum must be in (mid, right].
  // - Otherwise, the minimum lies in [left, mid].
  // Loop stops when left == right, which points to the minimum.
  public static int findMin(int[] nums) {
    // Defensive check (LeetCode guarantees non-empty)
    if (nums == null || nums.length == 0) {
      throw new IllegalArgumentException("nums must be non-empty");
    }

    int left = 0;
    int right = nums.length - 1;

    // Early exit: array is not rotated (already sorted)
    if (nums[left] <= nums[right]) {
      return nums[left];
    }

    // Binary search to locate the rotation pivot (minimum)
    while (left < right) {
      // Safe midpoint
      int mid = left + (right - left) / 2;

      // If mid element is greater than the rightmost, minimum is to the right
      if (nums[mid] > nums[right]) {
        left = mid + 1;
      } else {
        // Otherwise, minimum is at mid or to the left of mid
        right = mid;
      }
    }

    // left == right -> index of the smallest element
    return nums[left];
  }
}
