package io.github.cristianmanoliu.binary_search;

import java.util.Arrays;

// https://neetcode.io/problems/eating-bananas?list=neetcode150
// https://leetcode.com/problems/koko-eating-bananas
public class KokoEatingBananas {

  // Main function: find the minimum integer eating speed k such that
  // Koko can finish all piles within h hours.
  // Strategy: Binary search on k in [1, max(piles)].
  // For a candidate speed k, compute total hours = sum(ceil(pile / k)) and
  // check if it's <= h (feasible). Search the smallest feasible k.
  public int minEatingSpeed(int[] piles, int h) {
    // Left bound: at least 1 banana/hour
    int left = 1;
    // Right bound: at most the largest pile (finish that pile in 1 hour)
    int right = Arrays.stream(piles).max().getAsInt();

    // Standard binary search for the first feasible speed
    while (left <= right) {
      int mid = left + (right - left) / 2; // candidate speed
      if (canEatAll(piles, h, mid)) {
        // mid works -> try smaller speed
        right = mid - 1;
      } else {
        // mid too slow -> need faster speed
        left = mid + 1;
      }
    }
    // 'left' is the smallest feasible speed
    return left;
  }

  // Helper: given a speed k, return true if Koko can finish in <= h hours.
  private boolean canEatAll(int[] piles, int h, int k) {
    long hours = 0; // use long to avoid overflow when summing
    for (int pile : piles) {
      // ceil(pile / k) = (pile + k - 1) / k using integers
      hours += (pile + k - 1) / k;
      // (Optional early exit) if hours already exceed h, no need to continue
      if (hours > h) {
        return false;
      }
    }
    return hours <= h;
  }
}