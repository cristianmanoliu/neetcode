package io.github.cristianmanoliu.heap_priority_queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class KthLargestTest {

  @Test
  void example1() {
    KthLargest kthLargest = new KthLargest(3, new int[]{1, 2, 3, 3});
    assertEquals(3, kthLargest.add(3));
    assertEquals(3, kthLargest.add(5));
    assertEquals(3, kthLargest.add(6));
    assertEquals(5, kthLargest.add(7));
    assertEquals(6, kthLargest.add(8));
  }
}