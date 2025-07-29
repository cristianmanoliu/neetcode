package io.github.cristianmanoliu.two_pointers;

// https://neetcode.io/problems/two-integer-sum-ii?list=neetcode150
public class TwoIntegerSumII {

  public int[] twoSum(int[] numbers, int target) {
    int left = 0;
    int right = numbers.length - 1;
    while (left < right) {
      if (numbers[left] + numbers[right] == target) {
        return new int[]{left + 1, right + 1};
      } else if (numbers[left] + numbers[right] < target) {
        left++;
      } else {
        right--;
      }
    }
    return new int[]{};
  }
}
