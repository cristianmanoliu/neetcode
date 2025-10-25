package io.github.cristianmanoliu.binary_search;

// https://neetcode.io/problems/median-of-two-sorted-arrays?list=neetcode150
// https://leetcode.com/problems/median-of-two-sorted-arrays
public class MedianOfTwoSortedArrays {

  public double findMedianSortedArrays(int[] A, int[] B) {
    if (A.length > B.length) {
      return findMedianSortedArrays(B, A); // ensure A is smaller
    }

    int m = A.length, n = B.length;
    int totalLeft = (m + n + 1) / 2;
    int lo = 0, hi = m;

    while (lo <= hi) {
      int cutA = (lo + hi) / 2;
      int cutB = totalLeft - cutA;

      int leftA = (cutA == 0) ? Integer.MIN_VALUE : A[cutA - 1];
      int rightA = (cutA == m) ? Integer.MAX_VALUE : A[cutA];
      int leftB = (cutB == 0) ? Integer.MIN_VALUE : B[cutB - 1];
      int rightB = (cutB == n) ? Integer.MAX_VALUE : B[cutB];

      if (leftA <= rightB && leftB <= rightA) {
        if (((m + n) & 1) == 1) {
          return Math.max(leftA, leftB);
        } else {
          return (Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2.0;
        }
      } else if (leftA > rightB) {
        hi = cutA - 1;
      } else {
        lo = cutA + 1;
      }
    }

    throw new IllegalStateException("Inputs must be sorted");
  }
}