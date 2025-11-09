package io.github.cristianmanoliu.heap_priority_queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FindMedianFromDataStreamTest {

  @Test
  @DisplayName("Calling findMedian with no numbers throws")
  void emptyStreamThrows() {
    FindMedianFromDataStream medianFinder = new FindMedianFromDataStream();
    assertThrows(IllegalStateException.class, medianFinder::findMedian);
  }

  @Test
  @DisplayName("Single number -> that number is the median")
  void singleNumber() {
    FindMedianFromDataStream medianFinder = new FindMedianFromDataStream();
    medianFinder.addNum(5);
    assertEquals(5.0, medianFinder.findMedian(), 1e-9);
  }

  @Test
  @DisplayName("Two numbers -> median is their average")
  void twoNumbersAverage() {
    FindMedianFromDataStream medianFinder = new FindMedianFromDataStream();
    medianFinder.addNum(1);
    medianFinder.addNum(3);
    assertEquals(2.0, medianFinder.findMedian(), 1e-9);
  }

  @Test
  @DisplayName("Incremental median with odd and even counts")
  void incrementalMedian() {
    FindMedianFromDataStream medianFinder = new FindMedianFromDataStream();

    medianFinder.addNum(1);
    assertEquals(1.0, medianFinder.findMedian(), 1e-9);

    medianFinder.addNum(2);
    assertEquals(1.5, medianFinder.findMedian(), 1e-9);

    medianFinder.addNum(3);
    assertEquals(2.0, medianFinder.findMedian(), 1e-9);

    medianFinder.addNum(4);
    assertEquals(2.5, medianFinder.findMedian(), 1e-9);

    medianFinder.addNum(5);
    assertEquals(3.0, medianFinder.findMedian(), 1e-9);
  }

  @Test
  @DisplayName("Order of insertion does not matter")
  void insertionOrderIrrelevant() {
    FindMedianFromDataStream medianFinder = new FindMedianFromDataStream();

    medianFinder.addNum(5);
    medianFinder.addNum(1);
    medianFinder.addNum(3);
    // Numbers are [5,1,3] -> sorted [1,3,5] -> median = 3
    assertEquals(3.0, medianFinder.findMedian(), 1e-9);

    medianFinder.addNum(8);
    // Now: [5,1,3,8] -> sorted [1,3,5,8] -> median = (3+5)/2 = 4
    assertEquals(4.0, medianFinder.findMedian(), 1e-9);
  }

  @Test
  @DisplayName("Handles negative numbers and duplicates")
  void negativesAndDuplicates() {
    FindMedianFromDataStream medianFinder = new FindMedianFromDataStream();

    medianFinder.addNum(-1);
    medianFinder.addNum(-2);
    medianFinder.addNum(-3);
    medianFinder.addNum(-1);

    // Data: [-1,-2,-3,-1] -> sorted [-3,-2,-1,-1]
    // Median = (-2 + -1) / 2 = -1.5
    assertEquals(-1.5, medianFinder.findMedian(), 1e-9);

    medianFinder.addNum(0);
    // Now: [-3,-2,-1,-1,0] -> median is -1
    assertEquals(-1.0, medianFinder.findMedian(), 1e-9);
  }

  @Test
  @DisplayName("findMedian can be called multiple times without changing state")
  void repeatedFindMedian() {
    FindMedianFromDataStream medianFinder = new FindMedianFromDataStream();

    medianFinder.addNum(10);
    medianFinder.addNum(20);
    medianFinder.addNum(30);

    assertEquals(20.0, medianFinder.findMedian(), 1e-9);
    // Calling again should yield the same result.
    assertEquals(20.0, medianFinder.findMedian(), 1e-9);
  }
}
