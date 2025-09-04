package io.github.cristianmanoliu.heap_priority_queue;

import java.util.Arrays;
import java.util.Collections;

public class LastStoneWeight {

  // Max-heap to store the largest stones at the top.
  private final java.util.PriorityQueue<Integer> maxHeap = new java.util.PriorityQueue<>(Collections.reverseOrder());

  public int lastStoneWeight(int[] stones) {
    Arrays.stream(stones).forEach(maxHeap::offer);
    while (maxHeap.size() > 1) {
      int stone1 = maxHeap.poll();
      int stone2 = maxHeap.poll();
      if (stone1 != stone2) {
        maxHeap.offer(Math.abs(stone1 - stone2));
      }
    }
    return maxHeap.isEmpty() ? 0 : maxHeap.poll();
  }
}
