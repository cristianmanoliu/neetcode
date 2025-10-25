package io.github.cristianmanoliu.binary_search;

// https://neetcode.io/problems/find-minimum-in-rotated-sorted-array?list=neetcode150
// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class FindMinimumInRotatedSortedArray {

  public static int findMin(int[] nums) {
    // Optional: defensive checks for non-LeetCode environments
    if (nums == null || nums.length == 0) {
      throw new IllegalArgumentException("nums must be non-empty");
    }

    int left = 0;
    int right = nums.length - 1;

    // Early exit if already sorted (no rotation)
    if (nums[left] <= nums[right]) {
      return nums[left];
    }

    while (left < right) {
      int mid = left + (right - left) / 2;

      // If value at mid is greater than value at right,
      // the minimum lies strictly in (mid, right]
      if (nums[mid] > nums[right]) {
        left = mid + 1;
      } else {
        // Otherwise, the minimum lies in [left, mid]
        right = mid;
      }
    }

    // left == right points to the minimum
    return nums[left];
  }
}
