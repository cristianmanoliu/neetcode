package io.github.cristianmanoliu.graphs;

import java.util.ArrayDeque;
import java.util.Queue;

// https://neetcode.io/problems/islands-and-treasure?list=neetcode150
// https://leetcode.com/problems/islands-and-treasure/
public class IslandsAndTreasure {

  // Main function: fill each empty room (Integer.MAX_VALUE) with its distance
  // to the nearest treasure (cell == 0). Walls are -1, which are impassable.
  //
  // Strategy: multi-source BFS.
  // 1) Push all treasure cells (0s) into a queue as starting points (distance 0).
  // 2) BFS outward; when we first reach an empty room (INF), set its distance to
  //    parent_distance + 1 and enqueue it.
  // 3) We never revisit a cell because we only push previously-INF rooms.
  //
  // This guarantees minimal distances due to BFS layering from all sources.
  public void islandsAndTreasure(int[][] grid) {
    // Handle edge cases
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return;
    }

    final int rows = grid.length;
    final int cols = grid[0].length;
    final int INF = Integer.MAX_VALUE;

    // Queue for BFS over cell coordinates
    Queue<int[]> queue = new ArrayDeque<>();

    // Step 1: enqueue every treasure (0) as BFS source
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (grid[r][c] == 0) {
          queue.offer(new int[]{r, c});
        }
      }
    }

    // 4-directional deltas (down, up, right, left)
    final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    // Step 2: multi-source BFS
    while (!queue.isEmpty()) {
      int[] cell = queue.poll();
      int r = cell[0], c = cell[1];

      // Explore neighbors
      for (int[] d : DIRS) {
        int nr = r + d[0];
        int nc = c + d[1];

        // Bounds check
        if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
          continue;
        }

        // Only step into empty rooms (INF). Walls (-1) and already-filled cells are skipped.
        if (grid[nr][nc] == INF) {
          grid[nr][nc] = grid[r][c] + 1; // set distance from nearest treasure
          queue.offer(new int[]{nr, nc});
        }
      }
    }
  }
}
