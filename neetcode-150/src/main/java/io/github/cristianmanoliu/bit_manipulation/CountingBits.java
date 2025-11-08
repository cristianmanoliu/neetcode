package io.github.cristianmanoliu.bit_manipulation;

// https://neetcode.io/problems/counting-bits?list=neetcode150
// https://leetcode.com/problems/counting-bits/
public class CountingBits {

  // Main function: for each i in [0..n], compute the number of set bits in i.
  // Strategy (DP by halving):
  // - Use the identity: popcount(i) = popcount(i >> 1) + (i & 1).
  //   Explanation: shifting right drops the least-significant bit; add 1 if that bit was 1.
  // - Build dp bottom-up so each value is computed in O(1) from a smaller index.
  //
  // Complexity:
  // - Time:  O(n)
  // - Space: O(n) for the output array (no extra significant memory).
  public int[] countBits(int n) {
    int[] dp = new int[n + 1];
    // Base: dp[0] = 0 by default
    for (int i = 1; i <= n; i++) {
      dp[i] = dp[i >>> 1] + (i & 1); // use unsigned shift (same as >> for non-negative i)
    }
    return dp;
  }
}
