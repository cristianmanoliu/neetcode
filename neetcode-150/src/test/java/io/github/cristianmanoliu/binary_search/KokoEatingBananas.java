package io.github.cristianmanoliu.binary_search;

import java.util.Arrays;

// https://neetcode.io/problems/eating-bananas?list=neetcode150
public class KokoEatingBananas {

  public int minEatingSpeed(int[] piles, int h) {
    int left = 1;
    // max pile size
    int right = Arrays.stream(piles).max().getAsInt();
    while (left <= right) {
      int mid = left + (right - left) / 2;
      // can Koko eat all bananas with speed mid in h hours?
      if (canEatAll(piles, h, mid)) {
        // try to find a smaller speed
        right = mid - 1;
      } else {
        // need a larger speed
        left = mid + 1;
      }
    }
    return left;

  }

  // check if Koko can eat all bananas with speed mid in h hours
  private boolean canEatAll(int[] piles, int h, int mid) {
    int hours = 0;
    for (int pile : piles) {
      // ceil(pile / mid)
      hours += (int) Math.ceil((double) pile / mid);
    }
    return hours <= h;
  }
}
