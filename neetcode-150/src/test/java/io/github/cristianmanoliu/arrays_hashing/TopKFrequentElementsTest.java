package io.github.cristianmanoliu.arrays_hashing;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// JUnit 5 tests for TopKFrequentElements
class TopKFrequentElementsTest {

  // Helper: compare arrays ignoring order
  private void assertEqualsIgnoringOrder(int[] expected, int[] actual) {
    int[] e = expected.clone();
    int[] a = actual.clone();
    Arrays.sort(e);
    Arrays.sort(a);
    assertArrayEquals(e, a);
  }

  @Test
  @DisplayName("Empty input or k=0 -> empty output")
  void emptyCases() {
    TopKFrequentElements sol = new TopKFrequentElements();
    assertArrayEquals(new int[]{}, sol.topKFrequent(new int[]{}, 2));
    assertArrayEquals(new int[]{}, sol.topKFrequent(null, 2));
    assertArrayEquals(new int[]{}, sol.topKFrequent(new int[]{1, 1, 2}, 0));
  }

  @Test
  @DisplayName("Single element")
  void singleElement() {
    TopKFrequentElements sol = new TopKFrequentElements();
    assertArrayEquals(new int[]{5}, sol.topKFrequent(new int[]{5}, 1));
  }

  @Test
  @DisplayName("LeetCode-style example [1,1,1,2,2,3], k=2 -> {1,2}")
  void example1() {
    TopKFrequentElements sol = new TopKFrequentElements();
    int[] out = sol.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
    assertEqualsIgnoringOrder(new int[]{1, 2}, out);
  }

  @Test
  @DisplayName("k greater than unique count -> return all uniques")
  void kGreaterThanUnique() {
    TopKFrequentElements sol = new TopKFrequentElements();
    int[] out = sol.topKFrequent(new int[]{4, 4, 6}, 5);
    assertEqualsIgnoringOrder(new int[]{4, 6}, out);
  }

  @Test
  @DisplayName("Ties in frequency: any valid set of size k is acceptable")
  void tiesInFrequency() {
    TopKFrequentElements sol = new TopKFrequentElements();
    // Each of 1,2,3 appears twice
    int[] nums = {1, 1, 2, 2, 3, 3};
    int k = 2;

    int[] out = sol.topKFrequent(nums, k);

    // Result should contain exactly 2 distinct elements, both from {1,2,3}
    Set<Integer> valid = new HashSet<>(Arrays.asList(1, 2, 3));
    assertTrue(out.length == 2);
    assertTrue(valid.contains(out[0]) && valid.contains(out[1]) && out[0] != out[1]);
  }

  @Test
  @DisplayName("Mixed distribution")
  void mixedDistribution() {
    TopKFrequentElements sol = new TopKFrequentElements();
    // freq: 3->3 times, 2->2 times, 1->1 time
    int[] out = sol.topKFrequent(new int[]{3, 2, 3, 1, 2, 3}, 2);
    assertEqualsIgnoringOrder(new int[]{3, 2}, out);
  }
}
