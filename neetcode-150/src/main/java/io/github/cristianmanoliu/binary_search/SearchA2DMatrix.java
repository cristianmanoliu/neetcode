package io.github.cristianmanoliu.binary_search;

// https://neetcode.io/problems/search-2d-matrix?list=neetcode150
// https://leetcode.com/problems/search-a-2d-matrix
public class SearchA2DMatrix {

  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return false;
    }

    int top = 0;
    int bottom = matrix.length - 1;
    while (top <= bottom) {
      int midRow = top + (bottom - top) / 2;
      if (matrix[midRow][0] <= target && matrix[midRow][matrix[0].length - 1] >= target) {
        return search(matrix[midRow], target) != -1;
      } else if (matrix[midRow][0] < target) {
        top = midRow + 1;
      } else {
        bottom = midRow - 1;
      }
    }

    return false;
  }

  // Binary search solution
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
