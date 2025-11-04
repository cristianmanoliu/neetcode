package io.github.cristianmanoliu.graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MaxAreaOfIslandTest {

  @Test
  public void returnsZeroForEmptyGrid() {
    MaxAreaOfIsland solution = new MaxAreaOfIsland();
    int[][] grid = {};
    assertEquals(0, solution.maxAreaOfIsland(grid));
  }

  @Test
  public void returnsZeroForGridWithNoLand() {
    MaxAreaOfIsland solution = new MaxAreaOfIsland();
    int[][] grid = {
        {0, 0, 0},
        {0, 0, 0},
        {0, 0, 0}
    };
    assertEquals(0, solution.maxAreaOfIsland(grid));
  }

  @Test
  public void returnsCorrectAreaForSingleIsland() {
    MaxAreaOfIsland solution = new MaxAreaOfIsland();
    int[][] grid = {
        {1, 1, 0},
        {1, 1, 0},
        {0, 0, 0}
    };
    assertEquals(4, solution.maxAreaOfIsland(grid));
  }

  @Test
  public void returnsCorrectAreaForMultipleIslands() {
    MaxAreaOfIsland solution = new MaxAreaOfIsland();
    int[][] grid = {
        {1, 0, 0},
        {0, 1, 1},
        {0, 1, 0}
    };
    assertEquals(3, solution.maxAreaOfIsland(grid));
  }

}