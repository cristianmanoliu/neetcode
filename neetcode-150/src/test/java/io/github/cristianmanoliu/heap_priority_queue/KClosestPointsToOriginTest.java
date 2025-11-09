package io.github.cristianmanoliu.heap_priority_queue;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// JUnit 5 tests for KClosestPointsToOrigin
class KClosestPointsToOriginTest {

  private final KClosestPointsToOrigin sol = new KClosestPointsToOrigin();

  // Helper: sort points by (dist2, x, y) for stable comparison
  private int[][] normalize(int[][] pts) {
    int[][] copy = Arrays.stream(pts)
        .map(p -> new int[]{p[0], p[1]})
        .toArray(int[][]::new);
    Arrays.sort(copy, (a, b) -> {
      long da = 1L * a[0] * a[0] + 1L * a[1] * a[1];
      long db = 1L * b[0] * b[0] + 1L * b[1] * b[1];
      if (da != db) {
        return Long.compare(da, db);
      }
      if (a[0] != b[0]) {
        return Integer.compare(a[0], b[0]);
      }
      return Integer.compare(a[1], b[1]);
    });
    return copy;
  }

  private void assertSamePoints(int[][] expected, int[][] actual) {
    assertArrayEquals(normalize(expected), normalize(actual));
  }

  @Test
  @DisplayName("LeetCode example: [[1,3],[-2,2]], k=1 -> [[-2,2]]")
  void example1() {
    int[][] points = {{1, 3}, {-2, 2}};
    int[][] out = sol.kClosest(points, 1);
    assertSamePoints(new int[][]{{-2, 2}}, out);
  }

  @Test
  @DisplayName("Example: [[3,3],[5,-1],[-2,4]], k=2 -> any two closest")
  void example2() {
    int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
    int[][] out = sol.kClosest(points, 2);
    // Distances: (3,3)->18, (5,-1)->26, (-2,4)->20 -> pick (3,3) and (-2,4)
    assertSamePoints(new int[][]{{3, 3}, {-2, 4}}, out);
  }

  @Test
  @DisplayName("k equals number of points -> return all")
  void kEqualsN() {
    int[][] points = {{1, 0}, {0, 2}, {-2, 0}};
    int[][] out = sol.kClosest(points, 3);
    assertSamePoints(points, out);
  }

  @Test
  @DisplayName("k = 0 -> empty")
  void kZero() {
    int[][] points = {{2, 2}, {1, -1}};
    int[][] out = sol.kClosest(points, 0);
    assertSamePoints(new int[][]{}, out);
  }

  @Test
  @DisplayName("Handles negatives, duplicates, and ties")
  void negativesDuplicatesTies() {
    int[][] points = {{-1, -1}, {1, 1}, {1, -1}, {-1, 1}, {0, 2}, {2, 0}};
    // Dist^2: {-1,-1}=2, {1,1}=2, {1,-1}=2, {-1,1}=2, {0,2}=4, {2,0}=4
    int[][] out = sol.kClosest(points, 4);
    // Any four of the distance-2 points are valid
    int[][] expectedAny = {{-1, -1}, {1, 1}, {1, -1}, {-1, 1}};
    assertSamePoints(expectedAny, out);
  }

  @Test
  @DisplayName("k greater than number of points -> return all points")
  void kGreaterThanN() {
    int[][] points = {{3, 0}, {0, 4}};
    int[][] out = sol.kClosest(points, 5);
    assertSamePoints(points, out);
  }
}
