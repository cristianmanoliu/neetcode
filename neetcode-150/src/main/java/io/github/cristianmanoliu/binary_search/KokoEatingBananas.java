package io.github.cristianmanoliu.binary_search;

import java.util.Arrays;

// https://neetcode.io/problems/eating-bananas?list=neetcode150
// https://leetcode.com/problems/koko-eating-bananas
public class KokoEatingBananas {

  public int minEatingSpeed(int[] piles, int h) {
    int left = 1;
    int right = Arrays.stream(piles).max().getAsInt();

    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (canEatAll(piles, h, mid)) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

  private boolean canEatAll(int[] piles, int h, int mid) {
    long hours = 0;
    for (int pile : piles) {
      hours += (pile + mid - 1) / mid;
    }
    return hours <= h;
  }
}
