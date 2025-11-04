package io.github.cristianmanoliu.graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class NumberOfIslandsTest {

  @Test
  public void testNumIslands() {
    NumberOfIslands solution = new NumberOfIslands();

    char[][] grid1 = {
        {'1', '1', '0', '0', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '1', '0', '0'},
        {'0', '0', '0', '1', '1'}
    };
    assertEquals(3, solution.numIslands(grid1));

    char[][] grid2 = {
        {'1', '1', '1'},
        {'0', '1', '0'},
        {'1', '1', '1'}
    };
    assertEquals(1, solution.numIslands(grid2));

    char[][] grid3 = {
        {'1', '0', '1', '0'},
        {'0', '1', '0', '1'},
        {'1', '0', '1', '0'}
    };
    assertEquals(6, solution.numIslands(grid3));

    char[][] grid4 = {
        {'0', '0', '0'},
        {'0', '0', '0'},
        {'0', '0', '0'}
    };
    assertEquals(0, solution.numIslands(grid4));
  }

}