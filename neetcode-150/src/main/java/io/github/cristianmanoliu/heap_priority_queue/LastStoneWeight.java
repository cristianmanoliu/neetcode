package io.github.cristianmanoliu.heap_priority_queue;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

// https://neetcode.io/problems/last-stone-weight?list=neetcode150
// https://leetcode.com/problems/last-stone-weight/
public class LastStoneWeight {

  // Max-heap that always keeps the heaviest stones at the top.
  // We repeatedly extract the two heaviest stones to simulate the "smash".
  private final PriorityQueue<Integer> maxHeap =
      new PriorityQueue<>(Collections.reverseOrder());

  // Simulate the process of smashing stones:
  // - Repeatedly take the two heaviest stones.
  // - If they are equal, both are destroyed.
  // - If not, the new stone with weight = |x - y| goes back into the pool.
  // - Continue until at most one stone remains.
  // Return the last stone's weight, or 0 if none remain.
  public int lastStoneWeight(int[] stones) {
    // Ensure a clean heap state if this instance is reused.
    maxHeap.clear();

    // Push all initial stones into the max-heap.
    Arrays.stream(stones).forEach(maxHeap::offer);

    // Keep smashing as long as we have at least two stones.
    while (maxHeap.size() > 1) {
      // Take the two heaviest stones.
      Integer stone1 = maxHeap.poll();
      Integer stone2 = maxHeap.poll();
      if (stone1 == null || stone2 == null) {
        // Defensive check: should never happen given the size > 1 condition.
        throw new IllegalStateException("Heap underflow during poll; expected at least two elements.");
      }

      // Compute their difference: if they are equal, diff == 0.
      int diff = stone1 - stone2;

      // If there is a non-zero difference, the remaining fragment becomes a new stone.
      if (diff != 0) {
        maxHeap.offer(Math.abs(diff));
      }
      // If diff == 0, both stones are fully destroyed and we do not push anything back.
    }

    // At this point, we have either one stone left or none.
    Integer last = maxHeap.peek();
    // If heap is empty, return 0; otherwise return the last stone's weight.
    return last != null ? last : 0;
  }
}
