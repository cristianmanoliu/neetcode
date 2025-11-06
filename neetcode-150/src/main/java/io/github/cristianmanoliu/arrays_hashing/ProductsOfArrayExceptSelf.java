package io.github.cristianmanoliu.arrays_hashing;

// https://neetcode.io/problems/products-of-array-discluding-self?list=neetcode150
// https://leetcode.com/problems/product-of-array-except-self
public class ProductsOfArrayExceptSelf {

  // Main function: return an array where result[i] is the product of all elements
  // in nums except nums[i].
  //
  // Constraint (per problem): O(n) time, O(1) extra space (ignoring the output),
  // and typically *without using division*. We do two passes:
  // 1) Prefix pass: result[i] = product of nums[0..i-1]
  // 2) Suffix pass: multiply result[i] by product of nums[i+1..n-1]
  public int[] productExceptSelf(int[] nums) {
    // Edge case: null or empty input
    if (nums == null || nums.length == 0) {
      return new int[]{};
    }

    int n = nums.length;
    int[] result = new int[n];

    // Prefix products: result[i] holds product of all elements to the LEFT of i
    // Base: no elements to the left of 0 -> 1
    result[0] = 1;
    for (int i = 1; i < n; i++) {
      // result[i - 1] already stores product of nums[0..i-2]
      // multiply by nums[i - 1] to extend to nums[0..i-1]
      result[i] = result[i - 1] * nums[i - 1];
    }

    // Suffix products: walk from right to left, accumulating product of elements to the RIGHT
    int suffix = 1; // no elements to the right of last index -> 1
    for (int i = n - 1; i >= 0; i--) {
      // Multiply existing left product by the right product so far
      result[i] *= suffix;
      // Update suffix to include nums[i] for the next iteration to the left
      suffix *= nums[i];
    }

    return result;
  }
}
