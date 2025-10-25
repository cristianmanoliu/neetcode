package io.github.cristianmanoliu.binary_search;

// https://neetcode.io/problems/find-target-in-rotated-sorted-array?list=neetcode150
// https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchInRotatedSortedArray {

  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      }
      // Determine which side is properly sorted
      // Left side is sorted
      if (nums[left] <= nums[mid]) {
        // Check if target is within the sorted left side
        if (nums[left] <= target && target < nums[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
        // Right side is sorted
      } else {
        // Check if target is within the sorted right side
        if (nums[mid] < target && target <= nums[right]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
    }
    return -1;
  }
}
