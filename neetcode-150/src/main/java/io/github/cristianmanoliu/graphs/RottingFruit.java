package io.github.cristianmanoliu.graphs;

import java.util.ArrayDeque;
import java.util.Queue;

// https://neetcode.io/problems/rotting-fruit?list=neetcode150
// https://leetcode.com/problems/rotting-oranges
public class RottingFruit {

  // Main function: return the minimum number of minutes that must elapse until
  // no cell has a fresh orange. If impossible, return -1.
  //
  // Grid encoding:
  //   0 = empty cell
  //   1 = fresh orange
  //   2 = rotten orange
  //
  // Strategy (multi-source BFS):
  //   1) Count the number of fresh oranges and enqueue all initially rotten cells.
  //   2) Perform BFS in "minutes" (levels). Each minute, all currently rotten cells infect
  //      their 4-directional fresh neighbors (turn them to 2) and enqueue them.
  //   3) Track elapsed minutes while we are still infecting new cells (i.e., while fresh > 0
  //      and the queue isn't empty).
  //   4) If after BFS there remain fresh oranges, return -1; otherwise return minutes elapsed.
  //
  // Complexity:
  //   Time:  O(R * C) — each cell is enqueued/dequeued at most once
  //   Space: O(R * C) — queue in the worst case
  public int orangesRotting(int[][] grid) {
    // Defensive guard (LeetCode guarantees non-empty, but handle safely)
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    final int rows = grid.length;
    final int cols = grid[0].length;

    // Queue for positions of rotten oranges
    Queue<int[]> q = new ArrayDeque<>();
    int fresh = 0;

    // Initialize queue with all rotten oranges; count fresh ones
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (grid[r][c] == 2) {
          q.offer(new int[] { r, c });
        } else if (grid[r][c] == 1) {
          fresh++;
        }
      }
    }

    // If there were no fresh oranges to begin with, zero minutes required
    if (fresh == 0) {
      return 0;
    }

    // Directions: up, down, left, right
    final int[][] DIRS = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

    int minutes = 0;

    // BFS: process layer by layer; each layer represents one minute of rotting
    while (!q.isEmpty() && fresh > 0) {
      int size = q.size();
      // Process all currently rotten oranges in this minute
      for (int i = 0; i < size; i++) {
        int[] cur = q.poll();
        int r = cur[0], c = cur[1];

        // Infect 4-neighbors if they are fresh
        for (int[] d : DIRS) {
          int nr = r + d[0], nc = c + d[1];
          if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
          if (grid[nr][nc] == 1) { // fresh -> becomes rotten
            grid[nr][nc] = 2;
            fresh--;
            q.offer(new int[] { nr, nc });
          }
        }
      }
      // After processing one layer, one minute has passed (only if infections occurred)
      minutes++;
    }

    // If fresh remain, infection could not reach them -> impossible
    return (fresh == 0) ? minutes : -1;
  }
}
