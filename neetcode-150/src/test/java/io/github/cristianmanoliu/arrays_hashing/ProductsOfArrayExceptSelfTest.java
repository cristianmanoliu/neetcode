package io.github.cristianmanoliu.arrays_hashing;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class ProductsOfArrayExceptSelfTest {

  private final ProductsOfArrayExceptSelf products = new ProductsOfArrayExceptSelf();

  @Test
  void returnsProductExceptSelfForPositiveNumbers() {
    int[] result = products.productExceptSelf(new int[]{1, 2, 4, 6});
    assertArrayEquals(new int[]{48, 24, 12, 8}, result);
  }

  @Test
  void returnsProductExceptSelfWithZeroAndNegativeNumbers() {
    int[] result = products.productExceptSelf(new int[]{-1, 0, 1, 2, 3});
    assertArrayEquals(new int[]{0, -6, 0, 0, 0}, result);
  }
}