package io.github.cristianmanoliu.bit_manipulation;

// https://neetcode.io/problems/number-of-one-bits?list=neetcode150
// https://leetcode.com/problems/number-of-1-bits
public class NumberOfOneBits {

  // Main function: return the number of set bits ('1' bits) in a 32-bit integer.
  // Strategy (Brian Kernighan's algorithm):
  //   Repeatedly clear the lowest set bit via n &= (n - 1) and count how many times we do it.
  //   Each iteration removes exactly one '1' from n. Loop ends when n == 0.
  // Notes:
  //   - Works for any 32-bit int, including negative values (two's complement).
  //   - Faster than shifting through all 32 positions when the number of set bits is small.
  public int hammingWeight(int n) {
    int count = 0;
    while (n != 0) {
      n &= (n - 1); // clear the lowest set bit
      count++;      // we removed one '1'
    }
    return count;
  }
}