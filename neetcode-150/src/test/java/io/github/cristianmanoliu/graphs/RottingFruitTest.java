package io.github.cristianmanoliu.graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// JUnit 5 tests for RottingFruit
class RottingFruitTest {

  @Test
  @DisplayName("Example where all fresh eventually rot")
  void allRotInFourMinutes() {
    RottingFruit sol = new RottingFruit();
    int[][] grid = {
        {2,1,1},
        {1,1,0},
        {0,1,1}
    };
    assertEquals(4, sol.orangesRotting(grid));
  }

  @Test
  @DisplayName("Impossible to rot all due to isolation -> -1")
  void impossible() {
    RottingFruit sol = new RottingFruit();
    int[][] grid = {
        {2,1,1},
        {0,1,1},
        {1,0,1}
    };
    assertEquals(-1, sol.orangesRotting(grid));
  }

  @Test
  @DisplayName("No fresh oranges initially -> 0")
  void noFreshInitially() {
    RottingFruit sol = new RottingFruit();
    int[][] grid1 = { {0,2} };
    assertEquals(0, sol.orangesRotting(grid1));

    int[][] grid2 = { {2,2}, {0,2} };
    assertEquals(0, sol.orangesRotting(grid2));
  }

  @Test
  @DisplayName("Single cell scenarios")
  void singleCell() {
    RottingFruit sol = new RottingFruit();
    assertEquals(0,  sol.orangesRotting(new int[][] { {0} })); // empty
    assertEquals(0,  sol.orangesRotting(new int[][] { {2} })); // already rotten
    assertEquals(-1, sol.orangesRotting(new int[][] { {1} })); // fresh alone, never rots
  }

  @Test
  @DisplayName("Fresh blocked by walls of empties")
  void blockedByEmpties() {
    RottingFruit sol = new RottingFruit();
    int[][] grid = {
        {2,0,1}
    };
    assertEquals(-1, sol.orangesRotting(grid));
  }

  @Test
  @DisplayName("Multiple rotten sources reduce total time")
  void multipleSources() {
    RottingFruit sol = new RottingFruit();
    int[][] grid = {
        {2,1,1,0,2},
        {1,1,0,1,1}
    };
    // Two sources on ends; infection proceeds inward from both sides
    assertEquals(2, sol.orangesRotting(grid));
  }
}
