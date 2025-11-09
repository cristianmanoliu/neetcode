package io.github.cristianmanoliu.heap_priority_queue;

import java.util.PriorityQueue;

// https://neetcode.io/problems/kth-largest-integer-in-a-stream?list=neetcode150
// https://leetcode.com/problems/kth-largest-element-in-a-stream/
public class KthLargest {

  // Rank 'k' we are interested in: 1 means "largest", 2 means "2nd largest", etc.
  private final int k;

  // Min-heap that always stores at most the k largest elements seen so far.
  // The root (peek) is the smallest among those k elements,
  // i.e., the current k-th largest in the entire stream.
  private final PriorityQueue<Integer> minHeap;

  // Main idea:
  // - Use a min-heap of size at most k.
  // - For every value in the initial array and in add():
  //   * Push it into the heap if we have < k elements so far.
  //   * Otherwise, compare it with the heap's smallest (root):
  //     - If the new value is larger, it belongs in the top-k:
  //       remove the root and insert the new value.
  //     - Otherwise ignore it (it's not in the top-k).
  // - The heap's root is then the k-th largest value at any time.
  public KthLargest(int k, int[] nums) {
    // We cannot talk about the "0-th" largest value.
    if (k <= 0) {
      throw new IllegalArgumentException("k must be positive");
    }

    this.k = k;
    // Java's PriorityQueue is a min-heap by default (natural ordering).
    this.minHeap = new PriorityQueue<>(k);

    // Seed the data structure with any initial values.
    // Reuse the 'add' method so that we enforce the same invariants.
    if (nums != null) {
      for (int x : nums) {
        add(x); // ensures heap size never exceeds k
      }
    }
  }

  // Add one new value from the stream and return the current k-th largest.
  //
  // Invariant after this call:
  // - minHeap contains at most k elements.
  // - If we have seen at least k values total, minHeap contains exactly the k largest.
  // - minHeap.peek() is the k-th largest among all values seen so far.
  public int add(int val) {
    // Case 1: We have not yet collected k values -> just push.
    if (minHeap.size() < k) {
      minHeap.offer(val);
    } else {
      // Case 2: Heap already holds k elements.
      // The current k-th largest is at the root.
      Integer top = minHeap.peek(); // non-null when size == k

      // If the new value is larger than the current k-th largest,
      // it must join the top-k set: remove the old k-th largest and insert this one.
      if (top != null && val > top) {
        minHeap.poll();     // drop previous k-th largest
        minHeap.offer(val); // insert new candidate into top-k set
      }
      // Otherwise, val is not in the top-k and we can ignore it.
    }

    // At this point, the heap is non-empty (since k > 0 and we just inserted or had elements).
    Integer head = minHeap.peek();
    if (head == null) {
      // This should not occur if the constructor and 'add' maintain the invariant correctly.
      throw new IllegalStateException("Heap is empty; constructor invariants violated.");
    }

    // The root is always the current k-th largest value.
    return head;
  }
}