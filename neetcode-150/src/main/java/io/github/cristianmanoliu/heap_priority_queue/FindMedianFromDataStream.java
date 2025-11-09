package io.github.cristianmanoliu.heap_priority_queue;

import java.util.Collections;
import java.util.PriorityQueue;

// https://neetcode.io/problems/find-median-in-a-data-stream?list=neetcode150
// https://leetcode.com/problems/find-median-from-data-stream/
public class FindMedianFromDataStream {

  // Max-heap holding the smaller half of the numbers.
  // Root = largest element in the lower half.
  private final PriorityQueue<Integer> lower;

  // Min-heap holding the larger half of the numbers.
  // Root = smallest element in the upper half.
  private final PriorityQueue<Integer> higher;

  // Invariant:
  // - |lower.size() - higher.size()| <= 1
  // - lower.size() >= higher.size()
  // This makes median retrieval straightforward:
  // - If sizes differ: median is lower.peek().
  // - If sizes equal: median is average of lower.peek() and higher.peek().
  public FindMedianFromDataStream() {
    // Max-heap for lower half (reverse natural order).
    this.lower = new PriorityQueue<>(Collections.reverseOrder());
    // Min-heap for upper half (default natural order).
    this.higher = new PriorityQueue<>();
  }

  // Add a number into the data structure.
  //
  // Steps:
  // 1. Decide which heap to put 'num' into, based on lower.peek().
  // 2. Rebalance sizes so:
  //    - lower.size() == higher.size() or lower.size() == higher.size() + 1.
  public void addNum(int num) {
    // If lower is empty or num belongs to the lower half, push into 'lower'.
    if (lower.isEmpty() || num <= lower.peek()) {
      lower.offer(num);
    } else {
      // Otherwise it goes into the upper half.
      higher.offer(num);
    }

    // Rebalance so lower has at most one more element than higher.
    if (lower.size() > higher.size() + 1) {
      // Move one element from lower to higher.
      higher.offer(lower.poll());
    } else if (higher.size() > lower.size()) {
      // If higher has more, move one element to lower.
      lower.offer(higher.poll());
    }
  }

  // Return the current median of all inserted numbers.
  //
  // - If there are no numbers, we throw an exception.
  // - If heaps are same size, median is the average of both roots.
  // - Otherwise, lower has one extra element and its root is the median.
  public double findMedian() {
    if (lower.isEmpty() && higher.isEmpty()) {
      throw new IllegalStateException("No numbers available to compute median.");
    }

    if (lower.size() == higher.size()) {
      // Even count: average of the two middle values.
      return ((double) lower.peek() + (double) higher.peek()) / 2.0;
    } else {
      // Odd count: the extra element sits in 'lower'.
      return (double) lower.peek();
    }
  }
}
