package io.github.cristianmanoliu.heap_priority_queue;

import java.util.Arrays;
import java.util.Collections;

public class LastStoneWeight {

  // Max-heap to store the largest stones at the top.
  private final java.util.PriorityQueue<Integer> maxHeap =
      new java.util.PriorityQueue<>(Collections.reverseOrder());

  public int lastStoneWeight(int[] stones) {
    Arrays.stream(stones).forEach(maxHeap::offer);

    while (maxHeap.size() > 1) {
      Integer stone1 = maxHeap.poll();
      Integer stone2 = maxHeap.poll();
      if (stone1 == null || stone2 == null) {
        throw new IllegalStateException("Heap underflow during poll; expected at least two elements.");
      }
      int diff = stone1 - stone2;
      if (diff != 0) {
        maxHeap.offer(Math.abs(diff));
      }
    }

    Integer last = maxHeap.peek();
    return last != null ? last : 0;
  }
}