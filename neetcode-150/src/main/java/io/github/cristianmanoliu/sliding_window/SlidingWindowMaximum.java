package io.github.cristianmanoliu.sliding_window;

// https://neetcode.io/problems/sliding-window-maximum?list=neetcode150
public class SlidingWindowMaximum {

  public int[] maxSlidingWindow(int[] nums, int k) {
    if(nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
      return new int[]{};
    }
    int n = nums.length;
    int[] result = new int[n - k + 1];
    int left = 0;
    int right = 0;
    while(right < n) {
      // Expand the window
      if (right - left + 1 < k) {
        right++;
      } else {
        // Calculate the maximum in the current window
        int max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
          max = Math.max(max, nums[i]);
        }
        result[left] = max;
        // Move the window to the right
        left++;
        right++;
      }
    }
    return result;
  }
}
