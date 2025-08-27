package io.github.cristianmanoliu.binary_search;

// https://neetcode.io/problems/find-minimum-in-rotated-sorted-array?list=neetcode150
public class FindMinimumInRotatedSortedArray {

  public int findMin(int[] nums) {
    int left = 0;
    int right = nums.length - 1;
    while (left < right) {
      // prevent overflow
      int mid = left + (right - left) / 2;
      // mid is greater than right, so the minimum is in the right half
      if (nums[mid] > nums[right]) {
        // minimum is in the right half
        left = mid + 1;
      } else {
        // minimum is in the left half (including mid)
        right = mid;
      }
    }
    // left == right is the index of the minimum
    return nums[left];
  }
}
