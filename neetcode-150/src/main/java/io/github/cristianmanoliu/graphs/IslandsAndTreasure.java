package io.github.cristianmanoliu.graphs;

import java.util.ArrayDeque;
import java.util.Queue;

// https://neetcode.io/problems/islands-and-treasure?list=neetcode150
// https://leetcode.com/problems/islands-and-treasure/
public class IslandsAndTreasure {

  public void islandsAndTreasure(int[][] grid) {
    // Handle edge cases
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return;
    }

    // Initialize dimensions
    int rows = grid.length;
    int cols = grid[0].length;

    Queue<int[]> queue = new ArrayDeque<>();

    // Step 1: Add all treasures (0s) to the queue as starting points.
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (grid[r][c] == 0) {
          // Add treasure cell to the queue
          queue.offer(new int[]{r, c});
        }
      }
    }

    // Directions: up, down, left, right
    int[][] dirs = new int[][]{
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    // Step 2: Multi-source BFS
    while (!queue.isEmpty()) {
      // Dequeue the next cell
      int[] cell = queue.poll();
      // Current cell coordinates
      int r = cell[0];
      int c = cell[1];

      // Explore all 4 directions
      for (int[] d : dirs) {
        int nr = r + d[0];
        int nc = c + d[1];

        // Check bounds
        if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
          continue;
        }

        // Only update cells that are "infinite" (empty rooms)
        if (grid[nr][nc] == Integer.MAX_VALUE) {
          // Update distance
          grid[nr][nc] = grid[r][c] + 1; // distance from nearest treasure
          // Enqueue the updated cell
          queue.offer(new int[]{nr, nc});
        }
      }
    }
  }
}