package io.github.cristianmanoliu.heap_priority_queue;

import java.util.PriorityQueue;

// https://neetcode.io/problems/kth-largest-element-in-an-array?list=neetcode150
// https://leetcode.com/problems/kth-largest-element-in-an-array/
public class KthLargestElementInAnArray {

  // Find the k-th largest element in an unsorted array.
  //
  // Approach:
  // - Maintain a min-heap of size at most k.
  // - Insert each number into the heap.
  // - If the heap grows beyond size k, remove its smallest element.
  // - After processing all elements, the heap contains the k largest values,
  //   and the smallest among them (heap root) is the k-th largest overall.
  public int findKthLargest(int[] nums, int k) {
    // Basic argument validation to match LeetCode constraints logically:
    // k must be within [1, nums.length].
    if (nums == null) {
      throw new IllegalArgumentException("nums must not be null");
    }
    if (k <= 0 || k > nums.length) {
      throw new IllegalArgumentException("k must be between 1 and nums.length");
    }

    // Java's PriorityQueue is a min-heap by default.
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

    // Process each element in the array.
    for (int num : nums) {
      // Push current value into the heap.
      minHeap.offer(num);

      // If we hold more than k elements, drop the smallest one.
      // This keeps exactly the k largest elements seen so far.
      if (minHeap.size() > k) {
        minHeap.poll();
      }
    }

    // At this point we must have exactly k elements in the heap.
    // The root (peek) is the smallest among those k -> k-th largest overall.
    Integer kth = minHeap.peek();
    if (kth == null) {
      // Defensive guard; shouldn't happen if inputs satisfied constraints.
      throw new IllegalStateException("Heap unexpectedly empty; check input constraints.");
    }

    return kth;
  }
}