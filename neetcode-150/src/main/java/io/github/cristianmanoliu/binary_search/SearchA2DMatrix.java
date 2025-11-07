package io.github.cristianmanoliu.binary_search;

// https://neetcode.io/problems/search-2d-matrix?list=neetcode150
// https://leetcode.com/problems/search-a-2d-matrix
public class SearchA2DMatrix {

  // Main function: search 'target' in a 2D matrix with these properties:
  // 1) Each row is sorted ascending.
  // 2) The first integer of each row is greater than the last integer of the previous row.
  //
  // Strategy: Two-phase binary search.
  //   Phase 1: Binary search over rows to find the unique row whose range can contain target.
  //   Phase 2: Binary search within that row.
  public boolean searchMatrix(int[][] matrix, int target) {
    // Base checks: matrix and first row must be non-empty
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return false;
    }

    int cols = matrix[0].length;

    // Phase 1: locate the row (if any) whose [first, last] range contains target
    int top = 0;
    int bottom = matrix.length - 1;
    while (top <= bottom) {
      int midRow = top + (bottom - top) / 2;

      // If target is within the row's value range, search inside this row
      if (matrix[midRow][0] <= target && target <= matrix[midRow][cols - 1]) {
        return search(matrix[midRow], target) != -1;
      }
      // If target is greater than this row's last element, go downwards (later rows)
      else if (matrix[midRow][cols - 1] < target) {
        top = midRow + 1;
      }
      // Otherwise target is smaller than this row's first element, go upwards (earlier rows)
      else {
        bottom = midRow - 1;
      }
    }

    // No row range could contain target
    return false;
  }

  // Classic binary search on a 1D sorted array. Returns index or -1 if not found.
  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    // Loop invariant: if target exists, it lies within [left, right]
    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (nums[mid] == target) {
        return mid; // found
      } else if (nums[mid] < target) {
        left = mid + 1; // search right half
      } else {
        right = mid - 1; // search left half
      }
    }
    return -1; // not found
  }
}