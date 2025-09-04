package io.github.cristianmanoliu.heap_priority_queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LastStoneWeightTest {

  @Test
  void example1() {
    LastStoneWeight solver = new LastStoneWeight();
    int result = solver.lastStoneWeight(new int[]{2, 3, 6, 2, 4});
    assertEquals(1, result);
  }

  @Test
  void example2() {
    LastStoneWeight solver = new LastStoneWeight();
    int result = solver.lastStoneWeight(new int[]{1, 2});
    assertEquals(1, result);
  }
}