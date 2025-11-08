package io.github.cristianmanoliu.binary_search;

// https://neetcode.io/problems/median-of-two-sorted-arrays?list=neetcode150
// https://leetcode.com/problems/median-of-two-sorted-arrays
public class MedianOfTwoSortedArrays {

  // Main function: compute median of two sorted arrays in O(log(min(m, n))) time.
  // Strategy:
  // 1) Always binary-search on the *smaller* array (swap if needed).
  // 2) Choose cutA elements from A, cutB from B so that total left = (m+n+1)/2.
  // 3) Check partition is valid when leftA <= rightB and leftB <= rightA.
  // 4) If valid, compute median depending on parity of (m+n).
  //    - odd: max(leftA, leftB)
  //    - even: average of max(leftA,leftB) and min(rightA,rightB)
  public double findMedianSortedArrays(int[] A, int[] B) {
    // Ensure A is the smaller array to keep the binary search space minimal
    if (A.length > B.length) {
      return findMedianSortedArrays(B, A);
    }

    int m = A.length, n = B.length;
    int totalLeft = (m + n + 1) / 2; // number of elements on the left side of the partition
    int lo = 0, hi = m;              // binary search range for cutA: [0..m]

    // Binary search over cutA
    while (lo <= hi) {
      // cutA = how many from A go to the left partition
      int cutA = (lo + hi) / 2;
      // cutB = the rest needed from B to complete totalLeft
      int cutB = totalLeft - cutA;

      // Fetch border values around the cuts (sentinels for edges)
      int leftA = (cutA == 0) ? Integer.MIN_VALUE : A[cutA - 1];
      int rightA = (cutA == m) ? Integer.MAX_VALUE : A[cutA];
      int leftB = (cutB == 0) ? Integer.MIN_VALUE : B[cutB - 1];
      int rightB = (cutB == n) ? Integer.MAX_VALUE : B[cutB];

      // Valid partition if both left sides are <= the opposite right sides
      if (leftA <= rightB && leftB <= rightA) {
        // If total length is odd, median is the max of left-side borders
        if (((m + n) & 1) == 1) {
          return Math.max(leftA, leftB);
        } else {
          // Even length: average of max(lefts) and min(rights)
          // Cast to double before addition to avoid integer overflow
          return ((double) Math.max(leftA, leftB) + (double) Math.min(rightA, rightB)) / 2.0;
        }
      }
      // Otherwise adjust search range:
      // If leftA is too big, move cutA left; else move it right.
      else if (leftA > rightB) {
        hi = cutA - 1;
      } else {
        lo = cutA + 1;
      }
    }

    // If we exit the loop, inputs were not sorted as promised by the problem
    throw new IllegalStateException("Inputs must be sorted");
  }
}
