package io.github.cristianmanoliu.binary_search;

// https://neetcode.io/problems/binary-search?list=neetcode150
// https://leetcode.com/problems/binary-search/
public class BinarySearch {

  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return -1;
  }
}
