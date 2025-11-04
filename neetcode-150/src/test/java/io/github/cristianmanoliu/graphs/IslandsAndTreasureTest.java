package io.github.cristianmanoliu.graphs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class IslandsAndTreasureTest {

  private static final int INF = Integer.MAX_VALUE;

  private void assertGridEquals(int[][] expected, int[][] actual) {
    // Basic shape check
    assertArrayEquals(
        new int[]{expected.length, expected[0].length},
        new int[]{actual.length, actual[0].length},
        "Grid dimensions differ"
    );

    for (int r = 0; r < expected.length; r++) {
      assertArrayEquals(expected[r], actual[r],
          "Row " + r + " differs");
    }
  }

  @Test
  public void testSingleTreasureCenter() {
    IslandsAndTreasure solver = new IslandsAndTreasure();

    int[][] grid = {
        {INF, INF, INF},
        {INF, 0,   INF},
        {INF, INF, INF}
    };

    int[][] expected = {
        {2, 1, 2},
        {1, 0, 1},
        {2, 1, 2}
    };

    solver.islandsAndTreasure(grid);
    assertGridEquals(expected, grid);
  }

  @Test
  public void testWallsButAllReachable() {
    IslandsAndTreasure solver = new IslandsAndTreasure();

    int[][] grid = {
        {INF, -1,  0},
        {INF, INF, INF},
        {INF, -1,  INF}
    };

    // Distances computed by BFS from (0,2) with walls at (0,1) and (2,1)
    int[][] expected = {
        {4, -1, 0},
        {3,  2, 1},
        {4, -1, 2}
    };

    solver.islandsAndTreasure(grid);
    assertGridEquals(expected, grid);
  }

  @Test
  public void testUnreachableRoomsRemainINF() {
    IslandsAndTreasure solver = new IslandsAndTreasure();

    /*
      Layout:

      0  -1  INF
      INF -1 INF
      INF -1 INF

      Column 1 (index 1) is a wall barrier, so the rightmost column is unreachable.
     */
    int[][] grid = {
        {0,   -1, INF},
        {INF, -1, INF},
        {INF, -1, INF}
    };

    int[][] expected = {
        {0,  -1, INF},
        {1,  -1, INF},
        {2,  -1, INF}
    };

    solver.islandsAndTreasure(grid);
    assertGridEquals(expected, grid);
  }

  @Test
  public void testNoTreasureGridUnchanged() {
    IslandsAndTreasure solver = new IslandsAndTreasure();

    int[][] grid = {
        {INF, INF},
        {-1,  INF}
    };

    int[][] expected = {
        {INF, INF},
        {-1,  INF}
    };

    solver.islandsAndTreasure(grid);
    assertGridEquals(expected, grid);
  }

  @Test
  public void testRectangularGrid() {
    IslandsAndTreasure solver = new IslandsAndTreasure();

    /*
      Initial:
      [INF, INF, INF,   0]
      [INF, -1,  INF, INF]

      Expected distances:
      [3,   2,   1,   0]
      [4,  -1,   2,   1]
     */
    int[][] grid = {
        {INF, INF, INF, 0},
        {INF, -1,  INF, INF}
    };

    int[][] expected = {
        {3, 2, 1, 0},
        {4, -1, 2, 1}
    };

    solver.islandsAndTreasure(grid);
    assertGridEquals(expected, grid);
  }

  @Test
  public void testSingleCellTreasure() {
    IslandsAndTreasure solver = new IslandsAndTreasure();

    int[][] grid = {
        {0}
    };

    int[][] expected = {
        {0}
    };

    solver.islandsAndTreasure(grid);
    assertGridEquals(expected, grid);
  }

  @Test
  public void testSingleCellEmpty() {
    IslandsAndTreasure solver = new IslandsAndTreasure();

    int[][] grid = {
        {INF}
    };

    int[][] expected = {
        {INF}
    };

    solver.islandsAndTreasure(grid);
    assertGridEquals(expected, grid);
  }

  @Test
  public void testSingleCellWall() {
    IslandsAndTreasure solver = new IslandsAndTreasure();

    int[][] grid = {
        {-1}
    };

    int[][] expected = {
        {-1}
    };

    solver.islandsAndTreasure(grid);
    assertGridEquals(expected, grid);
  }
}
