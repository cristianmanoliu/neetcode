package io.github.cristianmanoliu.binary_search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SearchA2DMatrixTest {

  private final SearchA2DMatrix searchA2DMatrix = new SearchA2DMatrix();

  @Test
  void example1_searchMatrix_returnsTrue() {
    int[][] matrix = {
        {1, 2, 4, 8},
        {10, 11, 12, 13},
        {14, 20, 30, 40}
    };
    int target = 10;
    boolean expected = true;
    boolean result = searchA2DMatrix.searchMatrix(matrix, target);
    assertEquals(expected, result);
  }

  @Test
  void example2_searchMatrix_returnsFalse() {
    int[][] matrix = {
        {1, 2, 4, 8},
        {10, 11, 12, 13},
        {14, 20, 30, 40}
    };
    int target = 15;
    boolean expected = false;
    boolean result = searchA2DMatrix.searchMatrix(matrix, target);
    assertEquals(expected, result);
  }
}