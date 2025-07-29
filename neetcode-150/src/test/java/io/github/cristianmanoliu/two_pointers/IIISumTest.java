package io.github.cristianmanoliu.two_pointers;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.Test;

class IIISumTest {

  private final IIISum iiiSum = new IIISum();

  @Test
  void returnsCorrectTripletsForExample1() {
    int[] nums = {-1, 0, 1, 2, -1, -4};
    List<List<Integer>> expected = Arrays.asList(
        Arrays.asList(-1, -1, 2),
        Arrays.asList(-1, 0, 1)
    );
    List<List<Integer>> result = iiiSum.threeSum(nums);
    assertTrue(equalTripletLists(result, expected));
  }

  @Test
  void returnsEmptyListForExample2() {
    int[] nums = {0, 1, 1};
    List<List<Integer>> expected = Collections.emptyList();
    List<List<Integer>> result = iiiSum.threeSum(nums);
    assertTrue(equalTripletLists(result, expected));
  }

  @Test
  void returnsSingleTripletForExample3() {
    int[] nums = {0, 0, 0};
    List<List<Integer>> expected = Arrays.asList(
        Arrays.asList(0, 0, 0)
    );
    List<List<Integer>> result = iiiSum.threeSum(nums);
    assertTrue(equalTripletLists(result, expected));
  }

  @Test
  void returnsAllUniqueTripletsForMinusTwoZeroOneOneTwo() {
    int[] nums = {-2, 0, 1, 1, 2};
    List<List<Integer>> expected = Arrays.asList(
        Arrays.asList(-2, 0, 2),
        Arrays.asList(-2, 1, 1)
    );
    List<List<Integer>> result = iiiSum.threeSum(nums);
    assertTrue(equalTripletLists(result, expected));
  }

  @Test
  void returnsSingleUniqueTripletForInputWithDuplicates() {
    int[] nums = {1, -1, -1, 0};
    List<List<Integer>> expected = Arrays.asList(
        Arrays.asList(-1, 0, 1)
    );
    List<List<Integer>> result = iiiSum.threeSum(nums);
    assertTrue(equalTripletLists(result, expected));
  }

  // Helper to compare lists of triplets regardless of order
  private boolean equalTripletLists(List<List<Integer>> a, List<List<Integer>> b) {
    List<List<Integer>> aSorted = new ArrayList<>();
    for (List<Integer> triplet : a) {
      List<Integer> sorted = new ArrayList<>(triplet);
      Collections.sort(sorted);
      aSorted.add(sorted);
    }
    List<List<Integer>> bSorted = new ArrayList<>();
    for (List<Integer> triplet : b) {
      List<Integer> sorted = new ArrayList<>(triplet);
      Collections.sort(sorted);
      bSorted.add(sorted);
    }
    aSorted.sort(Comparator.comparing(Object::toString));
    bSorted.sort(Comparator.comparing(Object::toString));
    return aSorted.equals(bSorted);
  }
}