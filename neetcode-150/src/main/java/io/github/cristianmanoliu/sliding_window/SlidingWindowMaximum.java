package io.github.cristianmanoliu.sliding_window;

import java.util.ArrayDeque;
import java.util.Deque;

// https://neetcode.io/problems/sliding-window-maximum?list=neetcode150
public class SlidingWindowMaximum {

  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
      return new int[]{};
    }

    int n = nums.length;
    int[] result = new int[n - k + 1];
    Deque<Integer> deque = new ArrayDeque<>(); // Stores indices

    for (int right = 0; right < n; right++) {
      // Remove indices that are outside the current window
      while (!deque.isEmpty() && deque.peekFirst() < right - k + 1) {
        deque.pollFirst();
      }

      // Remove indices of elements smaller than nums[right]
      // They can never be the maximum in any future window
      while (!deque.isEmpty() && nums[deque.peekLast()] < nums[right]) {
        deque.pollLast();
      }

      // Add current element's index
      deque.offerLast(right);

      // Store the maximum for windows that have reached size k
      if (right >= k - 1) {
        result[right - k + 1] = nums[deque.peekFirst()];
      }
    }

    return result;
  }
}
