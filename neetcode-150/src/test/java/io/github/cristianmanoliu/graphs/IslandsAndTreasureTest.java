package io.github.cristianmanoliu.graphs;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IslandsAndTreasureTest {

  private static final int INF = Integer.MAX_VALUE;

  // Helper: assert two 2D int arrays are equal
  private void assertGridEquals(int[][] expected, int[][] actual) {
    for (int i = 0; i < expected.length; i++) {
      assertArrayEquals(expected[i], actual[i], "Row " + i + " differs");
    }
  }

  @Test
  @DisplayName("Classic example with walls, treasures, and rooms")
  void classicExample() {
    IslandsAndTreasure sol = new IslandsAndTreasure();

    int[][] grid = {
        {INF, -1, 0, INF},
        {INF, INF, INF, -1},
        {INF, -1, INF, -1},
        {0, -1, INF, INF}
    };

    int[][] expected = {
        {3, -1, 0, 1},
        {2, 2, 1, -1},
        {1, -1, 2, -1},
        {0, -1, 3, 4}
    };

    sol.islandsAndTreasure(grid);
    assertGridEquals(expected, grid);
  }

  @Test
  @DisplayName("Single treasure fills distances outward")
  void singleTreasureSmall() {
    IslandsAndTreasure sol = new IslandsAndTreasure();

    int[][] grid = {
        {INF, INF},
        {0, INF}
    };

    int[][] expected = {
        {1, 2},
        {0, 1}
    };

    sol.islandsAndTreasure(grid);
    assertGridEquals(expected, grid);
  }

  @Test
  @DisplayName("Multiple treasures: choose nearest")
  void multipleTreasures() {
    IslandsAndTreasure sol = new IslandsAndTreasure();

    int[][] grid = {
        {0, INF},
        {INF, 0}
    };

    int[][] expected = {
        {0, 1},
        {1, 0}
    };

    sol.islandsAndTreasure(grid);
    assertGridEquals(expected, grid);
  }

  @Test
  @DisplayName("Walls block paths (unreachable stays INF)")
  void wallsBlock() {
    IslandsAndTreasure sol = new IslandsAndTreasure();

    int[][] grid = {
        {0, -1, INF}
    };

    int[][] expected = {
        {0, -1, INF}
    };

    sol.islandsAndTreasure(grid);
    assertGridEquals(expected, grid);
  }

  @Test
  @DisplayName("No treasures: rooms remain INF")
  void noTreasures() {
    IslandsAndTreasure sol = new IslandsAndTreasure();

    int[][] grid = {
        {INF, -1},
        {INF, INF}
    };

    int[][] expected = {
        {INF, -1},
        {INF, INF}
    };

    sol.islandsAndTreasure(grid);
    assertGridEquals(expected, grid);
  }

  @Test
  @DisplayName("Empty or degenerate inputs are safely ignored")
  void emptyInputs() {
    IslandsAndTreasure sol = new IslandsAndTreasure();

    int[][] empty = new int[][]{};
    sol.islandsAndTreasure(empty); // should not throw

    int[][] rowEmpty = new int[][]{{}};
    sol.islandsAndTreasure(rowEmpty); // should not throw
  }
}