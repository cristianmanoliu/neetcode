package io.github.cristianmanoliu.heap_priority_queue;

import java.util.PriorityQueue;

// https://neetcode.io/problems/kth-largest-integer-in-a-stream?list=neetcode150
public class KthLargest {

  private final int k;
  // The minimum element is always at the root of the tree.
  private final PriorityQueue<Integer> minHeap;

  public KthLargest(int k, int[] nums) {
    if (k <= 0) {
      throw new IllegalArgumentException("k must be positive");
    }
    this.k = k;
    this.minHeap = new PriorityQueue<>(k);
    if (nums != null) {
      for (int x : nums) {
        add(x);
      }
    }
  }

  /**
   * Adds a new value into the stream and returns the k-th largest element so far. Time: O(log k) per call; Space: O(k) overall.
   */
  public int add(int val) {
    if (minHeap.size() < k) {
      minHeap.offer(val);
    } else if (val > minHeap.peek()) {
      minHeap.poll();
      minHeap.offer(val);
    }
    return minHeap.peek();
  }
}
