package io.github.cristianmanoliu.arrays_hashing;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class TopKFrequentElementsTest {

  private final TopKFrequentElements topKFrequentElements = new TopKFrequentElements();

  @Test
  void returnsTopKFrequentElementsForDistinctNumbers() {
    int[] result = topKFrequentElements.topKFrequent(new int[]{1, 2, 3, 1, 2, 1}, 2);
    assertArrayEquals(new int[]{1, 2}, result);
  }

  @Test
  void returnsTopKFrequentElementsForSingleElementArray() {
    int[] result = topKFrequentElements.topKFrequent(new int[]{1}, 1);
    assertArrayEquals(new int[]{1}, result);
  }

  @Test
  void returnsEmptyArrayWhenKIsZero() {
    int[] result = topKFrequentElements.topKFrequent(new int[]{1, 2, 3, 1, 2, 1}, 0);
    assertArrayEquals(new int[]{}, result);
  }

  @Test
  void handlesEmptyInputArray() {
    int[] result = topKFrequentElements.topKFrequent(new int[]{}, 1);
    assertArrayEquals(new int[]{}, result);
  }
}