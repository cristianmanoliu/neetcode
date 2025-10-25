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
   * Adds a new value into the stream and returns the k-th largest element so far.
   * <p>
   * Time: O(log k) per call; Space: O(k) overall.
   */
  public int add(int val) {
    if (minHeap.size() < k) {
      minHeap.offer(val);
    } else {
      Integer top = minHeap.peek(); // non-null under invariant, but guard defensively
      if (top != null && val > top) {
        minHeap.poll();
        minHeap.offer(val);
      }
    }
    Integer head = minHeap.peek();
    if (head == null) {
      throw new IllegalStateException("Heap is empty; ensure k > 0 and constructor invariants hold.");
    }
    return head;
  }

}
