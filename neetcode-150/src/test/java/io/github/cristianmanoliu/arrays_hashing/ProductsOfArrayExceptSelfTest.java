package io.github.cristianmanoliu.arrays_hashing;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductsOfArrayExceptSelfTest {

  private final ProductsOfArrayExceptSelf sol = new ProductsOfArrayExceptSelf();

  @Test
  @DisplayName("Empty input -> empty output")
  void emptyInput() {
    assertArrayEquals(new int[]{}, sol.productExceptSelf(new int[]{}));
  }

  @Test
  @DisplayName("Single element -> [1]")
  void singleElement() {
    assertArrayEquals(new int[]{1}, sol.productExceptSelf(new int[]{5}));
  }

  @Test
  @DisplayName("LeetCode example: [1,2,3,4] -> [24,12,8,6]")
  void example1() {
    assertArrayEquals(new int[]{24, 12, 8, 6}, sol.productExceptSelf(new int[]{1, 2, 3, 4}));
  }

  @Test
  @DisplayName("Example with one zero: [-1,1,0,-3,3] -> [0,0,9,0,0]")
  void exampleWithOneZero() {
    assertArrayEquals(new int[]{0, 0, 9, 0, 0}, sol.productExceptSelf(new int[]{-1, 1, 0, -3, 3}));
  }

  @Test
  @DisplayName("Two zeros -> all zeros")
  void twoZeros() {
    assertArrayEquals(new int[]{0, 0, 0}, sol.productExceptSelf(new int[]{0, 4, 0}));
  }

  @Test
  @DisplayName("Mixed signs")
  void mixedSigns() {
    assertArrayEquals(new int[]{-12, 8, -6}, sol.productExceptSelf(new int[]{2, -3, 4}));
  }

  @Test
  @DisplayName("All ones -> all ones")
  void allOnes() {
    assertArrayEquals(new int[]{1, 1, 1, 1}, sol.productExceptSelf(new int[]{1, 1, 1, 1}));
  }
}
