package io.github.cristianmanoliu.graphs;

// https://neetcode.io/problems/count-number-of-islands?list=neetcode150
// https://leetcode.com/problems/number-of-islands
public class NumberOfIslands {

  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }

    // Dimensions of the grid
    // m = number of rows, n = number of columns
    int m = grid.length;
    int n = grid[0].length;

    // Visited cells tracker
    boolean[][] visited = new boolean[m][n];

    // Number of islands counter
    int numOfIslands = 0;

    // Traverse each cell in the grid
    // Traverse each row
    for (int i = 0; i < m; i++) {
      // Traverse each column in the current row
      for (int j = 0; j < n; j++) {
        // If the cell is land and not visited, it's a new island
        if (grid[i][j] == '1' && !visited[i][j]) {
          // Increment island count
          numOfIslands++;
          // Perform DFS to mark all connected land cells as visited
          dfs(i, j, grid, visited);
        }
      }
    }
    return numOfIslands;
  }

  private void dfs(int i, int j, char[][] grid, boolean[][] visited) {
    // Dimensions of the grid
    // m = number of rows, n = number of columns
    int m = grid.length;
    int n = grid[0].length;

    // Out of bounds
    if (i < 0 || i >= m || j < 0 || j >= n) {
      return;
    }

    // Water or already visited
    if (grid[i][j] == '0' || visited[i][j]) {
      return;
    }

    // Mark cell as visited
    visited[i][j] = true;

    // Explore neighbors: down, up, right, left
    // Down
    dfs(i + 1, j, grid, visited);
    // Up
    dfs(i - 1, j, grid, visited);
    // Right
    dfs(i, j + 1, grid, visited);
    // Left
    dfs(i, j - 1, grid, visited);
  }
}
