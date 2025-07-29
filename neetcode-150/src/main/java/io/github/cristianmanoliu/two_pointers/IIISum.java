package io.github.cristianmanoliu.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://neetcode.io/problems/three-integer-sum?list=neetcode150
public class IIISum {

  record Triplet(int a, int b, int c) {

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Triplet triplet)) {
        return false;
      }
      return a == triplet.a && b == triplet.b && c == triplet.c;
    }

    @Override
    public int hashCode() {
      return 31 * a + 31 * b + 31 * c;
    }
  }

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Set<Triplet> tripletSet = new HashSet<>();
    Arrays.sort(nums);
    System.out.println("Sorted input: " + Arrays.toString(nums));
    for (int main = 0; main < nums.length - 2; main++) {
      int leftPointer = main + 1;
      int rightPointer = nums.length - 1;
      while (leftPointer < rightPointer) {
        int sum = nums[main] + nums[leftPointer] + nums[rightPointer];
        System.out.println("Checking triplet: " + nums[main] + ", " + nums[leftPointer] + ", " + nums[rightPointer]);
        if (sum == 0) {
          Triplet triplet = new Triplet(nums[main], nums[leftPointer], nums[rightPointer]);
          if (!tripletSet.contains(triplet)) {
            tripletSet.add(triplet);
            result.add(List.of(triplet.a, triplet.b, triplet.c));
            System.out.println("Found triplet: " + triplet);
          } else {
            System.out.println("Duplicate triplet found: " + triplet);
          }
          rightPointer--;
        } else if (sum < 0) {
          System.out.println("Sum is less than zero, moving left pointer from " + nums[leftPointer]);
          leftPointer++;
        } else {
          System.out.println("Sum is greater than zero, moving right pointer from " + nums[rightPointer]);
          rightPointer--;
        }
      }
    }
    return result;
  }
}
