package io.github.cristianmanoliu.heap_priority_queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class KthLargestTest {

  @Test
  @DisplayName("Typical usage from problem example")
  void typicalStreamExample() {
    KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});

    // After adding each value, we expect the current 3rd largest.
    assertEquals(4, kthLargest.add(3));   // stream: [4,5,8,2,3]
    assertEquals(5, kthLargest.add(5));   // stream: [4,5,8,2,3,5]
    assertEquals(5, kthLargest.add(10));  // stream: [4,5,8,2,3,5,10]
    assertEquals(8, kthLargest.add(9));   // stream: [4,5,8,2,3,5,10,9]
    assertEquals(8, kthLargest.add(4));   // stream: [4,5,8,2,3,5,10,9,4]
  }

  @Test
  @DisplayName("Initial array shorter than k still works as top-k grows")
  void initialArrayShorterThanK() {
    KthLargest kthLargest = new KthLargest(3, new int[]{5});

    // Only 2 elements so far: k-th largest degenerates to the minimum seen.
    assertEquals(2, kthLargest.add(2));   // stream: [5,2]
    assertEquals(2, kthLargest.add(10));  // stream: [5,2,10]

    // Now we have at least k elements; heap contains the 3 largest.
    assertEquals(5, kthLargest.add(9));   // stream: [5,2,10,9]
  }

  @Test
  @DisplayName("All new values smaller than current k-th largest are ignored")
  void smallerValuesDoNotChangeAnswer() {
    KthLargest kthLargest = new KthLargest(2, new int[]{5, 7});

    // Initial state: stream [5,7] -> 2nd largest is 5.
    assertEquals(5, kthLargest.add(4));   // 4 < current 2nd largest -> answer unchanged
    assertEquals(5, kthLargest.add(-1));  // still unchanged
  }

  @Test
  @DisplayName("Handles negative numbers correctly")
  void handlesNegativeNumbers() {
    KthLargest kthLargest = new KthLargest(2, new int[]{-10, -3, -4});

    // Stream: [-10, -3, -4] -> sorted desc [ -3, -4, -10 ] -> 2nd largest is -4
    assertEquals(-4, kthLargest.add(-5)); // stream: [-10,-3,-4,-5] -> 2nd largest remains -4

    // Now add a non-negative number; 2nd largest should update.
    // Full stream: [-10,-3,-4,-5,0] -> sorted desc [0, -3, -4, -5, -10] -> 2nd largest is -3
    assertEquals(-3, kthLargest.add(0));
  }

  @Test
  @DisplayName("Null initial array behaves like empty stream")
  void nullInitialArray() {
    KthLargest kthLargest = new KthLargest(1, null);

    // First value becomes the largest.
    assertEquals(7, kthLargest.add(7));

    // Larger value updates the 1st largest.
    assertEquals(10, kthLargest.add(10));
  }

  @Test
  @DisplayName("k must be positive")
  void invalidKThrows() {
    assertThrows(IllegalArgumentException.class, () -> new KthLargest(0, new int[]{}));
    assertThrows(IllegalArgumentException.class, () -> new KthLargest(-1, new int[]{1, 2, 3}));
  }
}
