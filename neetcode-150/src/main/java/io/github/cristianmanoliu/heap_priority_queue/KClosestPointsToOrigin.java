package io.github.cristianmanoliu.heap_priority_queue;

import java.util.PriorityQueue;

// https://neetcode.io/problems/k-closest-points-to-origin?list=neetcode150
// https://leetcode.com/problems/k-closest-points-to-origin/description/
public class KClosestPointsToOrigin {

  // Main function: return k points closest to (0,0).
  // Strategy (heap):
  //   - Use a max-heap of size at most k keyed by squared distance d = x*x + y*y.
  //   - For each point, push into heap; if heap size > k, remove the farthest.
  //   - Squared distances avoid sqrt and preserve ordering.
  // Complexity:
  //   - Time:  O(n log k), where n = number of points.
  //   - Space: O(k) for the heap.
  public int[][] kClosest(int[][] points, int k) {
    // Defensive: handle degenerate cases
    if (points == null || k <= 0) {
      return new int[0][0];
    }

    // Max-heap by squared distance: larger distance should come first
    PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
        (a, b) -> Integer.compare(dist2(b), dist2(a))
    );

    for (int[] p : points) {
      maxHeap.offer(p);
      if (maxHeap.size() > k) {
        maxHeap.poll(); // remove farthest to keep only k closest so far
      }
    }

    int size = Math.min(k, maxHeap.size());
    int[][] res = new int[size][2];
    for (int i = 0; i < size; i++) {
      int[] p = maxHeap.poll();
      // Copy coordinates into result (avoid aliasing original arrays)
      res[i][0] = p[0];
      res[i][1] = p[1];
    }
    return res;
  }

  // Squared Euclidean distance to origin; for LeetCode constraints (|coord| ≤ 1e4),
  // x*x + y*y fits safely in 32-bit int (≤ 2e8).
  private int dist2(int[] p) {
    return p[0] * p[0] + p[1] * p[1];
  }
}
