package io.github.cristianmanoliu.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IIISum {

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Set<Triplet> tripletSet = new HashSet<>();
    Arrays.sort(nums);

    for (int main = 0; main < nums.length - 2; main++) {
      int left = main + 1, right = nums.length - 1;
      while (left < right) {
        int sum = nums[main] + nums[left] + nums[right];
        if (sum == 0) {
          Triplet triplet = new Triplet(nums[main], nums[left], nums[right]);
          if (tripletSet.add(triplet)) {
            result.add(List.of(triplet.a, triplet.b, triplet.c));
          }
          right--;
        } else if (sum < 0) {
          left++;
        } else {
          right--;
        }
      }
    }
    return result;
  }

  record Triplet(int a, int b, int c) {

  }
}
