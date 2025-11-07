package io.github.cristianmanoliu.binary_search;

// https://neetcode.io/problems/find-target-in-rotated-sorted-array?list=neetcode150
// https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchInRotatedSortedArray {

  // Main function: search for 'target' in a rotated sorted array with distinct values.
  // Strategy: Modified binary search.
  // At each step, one side [left..mid] or [mid..right] is guaranteed to be sorted.
  // - If left half is sorted and target lies in it, move right pointer left.
  // - Else search the other half. Similarly handle when right half is sorted.
  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
      // Safe midpoint
      int mid = left + (right - left) / 2;

      // Found it
      if (nums[mid] == target) {
        return mid;
      }

      // Determine which half is sorted
      if (nums[left] <= nums[mid]) {
        // Left half [left..mid] is sorted
        if (nums[left] <= target && target < nums[mid]) {
          // Target is within the left half range -> discard right half
          right = mid - 1;
        } else {
          // Target must be in the right half
          left = mid + 1;
        }
      } else {
        // Right half [mid..right] is sorted
        if (nums[mid] < target && target <= nums[right]) {
          // Target in right half -> discard left half
          left = mid + 1;
        } else {
          // Target must be in the left half
          right = mid - 1;
        }
      }
    }

    // Not found
    return -1;
  }
}