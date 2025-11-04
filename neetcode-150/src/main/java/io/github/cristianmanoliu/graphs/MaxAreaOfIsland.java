package io.github.cristianmanoliu.graphs;

// https://neetcode.io/problems/max-area-of-island?list=neetcode150
// https://leetcode.com/problems/max-area-of-island
public class MaxAreaOfIsland {

  public int maxAreaOfIsland(int[][] grid) {
    // Edge case: empty grid
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    // Dimensions of the grid
    // Rows and columns
    int rows = grid.length;
    int cols = grid[0].length;

    // Variable to track the maximum area found
    int maxArea = 0;

    // Iterate through each cell in the grid
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        // If the cell is land (1), perform DFS to find the area of the island
        if (grid[r][c] == 1) {
          // Perform DFS to calculate the area of the island
          int area = dfs(grid, r, c);
          // Update maxArea if the current area is larger
          if (area > maxArea) {
            maxArea = area;
          }
        }
      }
    }
    return maxArea;
  }

  private int dfs(int[][] grid, int r, int c) {
    // Dimensions of the grid
    int rows = grid.length;
    int cols = grid[0].length;

    // Out of bounds or water/visited -> no contribution to area
    if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == 0) {
      return 0;
    }

    // Mark current cell as visited
    grid[r][c] = 0;

    int area = 1; // count current cell

    // Explore 4-directionally
    area += dfs(grid, r + 1, c);
    area += dfs(grid, r - 1, c);
    area += dfs(grid, r, c + 1);
    area += dfs(grid, r, c - 1);

    return area;
  }
}
