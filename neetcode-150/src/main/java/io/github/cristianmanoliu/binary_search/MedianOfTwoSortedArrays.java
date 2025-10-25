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

    // Binary search on smaller array
    while (lo <= hi) {
      // Compute cuts
      // Cut is the number of elements taken from the array
      int cutA = (lo + hi) / 2;
      // totalLeft - cutA is the number of elements taken from B
      int cutB = totalLeft - cutA;

      // Get left and right values around the cuts
      // Use sentinel values for edges to avoid out-of-bounds checks
      // Integer.MIN_VALUE and Integer.MAX_VALUE act as -infinity and +infinity for comparisons purposes
      int leftA = (cutA == 0) ? Integer.MIN_VALUE : A[cutA - 1];
      int rightA = (cutA == m) ? Integer.MAX_VALUE : A[cutA];
      int leftB = (cutB == 0) ? Integer.MIN_VALUE : B[cutB - 1];
      int rightB = (cutB == n) ? Integer.MAX_VALUE : B[cutB];

      // Check if we have found the correct cuts
      if (leftA <= rightB && leftB <= rightA) {
        // Found the correct cuts, compute the median
        if (((m + n) & 1) == 1) {
          // Odd total length
          return Math.max(leftA, leftB);
        } else {
          // Even total length
          return (Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2.0;
        }
        // Adjust search range
      } else if (leftA > rightB) {
        // Move cutA to the left
        hi = cutA - 1;
      } else {
        // Move cutA to the right
        lo = cutA + 1;
      }
    }

    throw new IllegalStateException("Inputs must be sorted");
  }
}