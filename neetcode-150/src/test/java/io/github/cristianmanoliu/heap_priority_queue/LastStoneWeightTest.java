package io.github.cristianmanoliu.heap_priority_queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LastStoneWeightTest {

  @Test
  @DisplayName("Example case from the problem statement")
  void exampleCase() {
    LastStoneWeight solver = new LastStoneWeight();
    // Example: [2,7,4,1,8,1] -> result should be 1
    assertEquals(1, solver.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
  }

  @Test
  @DisplayName("Single stone returns its own weight")
  void singleStone() {
    LastStoneWeight solver = new LastStoneWeight();
    assertEquals(5, solver.lastStoneWeight(new int[]{5}));
  }

  @Test
  @DisplayName("Two equal stones destroy each other to zero")
  void twoEqualStones() {
    LastStoneWeight solver = new LastStoneWeight();
    assertEquals(0, solver.lastStoneWeight(new int[]{3, 3}));
  }

  @Test
  @DisplayName("Two unequal stones return their absolute difference")
  void twoUnequalStones() {
    LastStoneWeight solver = new LastStoneWeight();
    assertEquals(1, solver.lastStoneWeight(new int[]{4, 3}));
  }

  @Test
  @DisplayName("Multiple stones with repeated smashing steps")
  void multipleStones() {
    LastStoneWeight solver = new LastStoneWeight();

    // All the same except one extra: [3,3,3] -> final stone weight is 3
    assertEquals(3, solver.lastStoneWeight(new int[]{3, 3, 3}));

    // Pairs that cancel out: [1,1,2,2] -> all destroyed -> 0
    assertEquals(0, solver.lastStoneWeight(new int[]{1, 1, 2, 2}));
  }

  @Test
  @DisplayName("Empty array yields zero (no stones)")
  void emptyArray() {
    LastStoneWeight solver = new LastStoneWeight();
    assertEquals(0, solver.lastStoneWeight(new int[]{}));
  }

  @Test
  @DisplayName("Solver instance can be safely reused across calls")
  void reusableInstance() {
    LastStoneWeight solver = new LastStoneWeight();

    assertEquals(1, solver.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
    assertEquals(0, solver.lastStoneWeight(new int[]{2, 2}));
    assertEquals(3, solver.lastStoneWeight(new int[]{3, 3, 3}));
  }
}
