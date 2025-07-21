package io.github.cristianmanoliu.arrays_hashing;

public class ProductsOfArrayExceptSelf {

  public int[] productExceptSelf(int[] nums) {
    if (nums == null || nums.length == 0) {
      return new int[]{}; // Return empty array if input is null or empty
    }

    int allProduct = 1;
    for (int num : nums) {
      allProduct *= num; // Calculate the product of all elements
    }

    int[] result = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        result[i] = allProduct / nums[i]; // Divide the total product by the current element
      } else {
        // If the current element is zero, we need to handle it separately
        int productWithoutTheCurrentZero = 1;
        for (int j = 0; j < nums.length; j++) {
          if (j != i) {
            productWithoutTheCurrentZero *= nums[j]; // Calculate product of all other elements
          }
        }
        result[i] = productWithoutTheCurrentZero; // Set the result for the zero element
      }
    }

    return result;
  }
}