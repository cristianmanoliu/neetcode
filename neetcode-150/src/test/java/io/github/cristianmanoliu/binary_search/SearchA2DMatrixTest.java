package io.github.cristianmanoliu.binary_search;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// JUnit 5 tests for SearchA2DMatrix
class SearchA2DMatrixTest {

  private final SearchA2DMatrix sol = new SearchA2DMatrix();

  @Test
  @DisplayName("Empty matrix or empty row -> false")
  void emptyInputs() {
    assertFalse(sol.searchMatrix(new int[][] {}, 1));
    assertFalse(sol.searchMatrix(new int[][] {{}}, 1));
  }

  @Test
  @DisplayName("Single element matrix")
  void singleElement() {
    assertTrue(sol.searchMatrix(new int[][] {{7}}, 7));
    assertFalse(sol.searchMatrix(new int[][] {{7}}, 8));
  }

  @Test
  @DisplayName("LeetCode example matrix")
  void leetcodeExample() {
    int[][] m = {
        {1, 3, 5, 7},
        {10, 11, 16, 20},
        {23, 30, 34, 60}
    };
    assertTrue(sol.searchMatrix(m, 3));
    assertFalse(sol.searchMatrix(m, 13));
  }

  @Test
  @DisplayName("Row boundary edges: last of a row and first of the next")
  void rowBoundaries() {
    int[][] m = {
        {1, 3, 5, 7},
        {10, 11, 16, 20},
        {23, 30, 34, 60}
    };
    assertTrue(sol.searchMatrix(m, 7));   // last of row 0
    assertTrue(sol.searchMatrix(m, 10));  // first of row 1
  }

  @Test
  @DisplayName("Target below global min and above global max")
  void outsideGlobalRange() {
    int[][] m = {
        {-5, -3, -1},
        {0, 2, 4},
        {6, 8, 10}
    };
    assertFalse(sol.searchMatrix(m, -6));
    assertFalse(sol.searchMatrix(m, 11));
  }

  @Test
  @DisplayName("Single row and single column matrices")
  void singleRowSingleCol() {
    int[][] row = {{1, 2, 4, 8, 16}};
    assertTrue(sol.searchMatrix(row, 1));
    assertTrue(sol.searchMatrix(row, 16));
    assertFalse(sol.searchMatrix(row, 3));

    int[][] col = {{1}, {3}, {5}, {7}};
    assertTrue(sol.searchMatrix(col, 5));
    assertFalse(sol.searchMatrix(col, 6));
  }

  @Test
  @DisplayName("Negatives and positives mixed")
  void negativesMixed() {
    int[][] m = {
        {-10, -7, -4},
        {-1,  0,  3},
        { 5,  9, 12}
    };
    assertTrue(sol.searchMatrix(m, -7));
    assertTrue(sol.searchMatrix(m, 12));
    assertFalse(sol.searchMatrix(m, 8));
  }
}