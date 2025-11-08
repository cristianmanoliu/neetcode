package io.github.cristianmanoliu.graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// JUnit 5 tests for CloneGraph
class CloneGraphTest {

  // Helper: structural sanity check.
  // Assumes unique node values (as in LeetCode: 1..N).
  // Verifies:
  //  - All original nodes map to distinct cloned nodes (no shared references).
  //  - Values match and neighbor sets (by value) match for every visited node.
  //  - Graph size (reachable component) is preserved.
  private void assertGraphCloned(Node orig, Node clone) {
    // Both null considered equal; caller avoids null here for brevity.
    Map<Integer, Node> byValClone = new HashMap<>();
    // BFS through both graphs simultaneously using mapping original->clone
    Map<Node, Node> map = new HashMap<>();
    Queue<Node> q = new ArrayDeque<>();

    map.put(orig, clone);
    q.offer(orig);

    while (!q.isEmpty()) {
      Node u = q.poll();
      Node v = map.get(u);

      // Different instances
      assertNotSame(u, v, "Clone must be a different instance than original");

      // Same value
      assertEquals(u.val, v.val, "Node values must match");

      // Record unique clone per value (guards accidental reuse)
      byValClone.putIfAbsent(v.val, v);

      // Compare neighbor value sets (order-insensitive)
      Set<Integer> uNeiVals = new HashSet<>();
      for (Node x : u.neighbors) uNeiVals.add(x.val);
      Set<Integer> vNeiVals = new HashSet<>();
      for (Node y : v.neighbors) vNeiVals.add(y.val);
      assertEquals(uNeiVals, vNeiVals, "Neighbor value sets must match");

      // Enqueue neighbors and extend mapping
      for (Node un : u.neighbors) {
        // Find the corresponding clone neighbor by value
        Node vn = null;
        for (Node cand : v.neighbors) {
          if (cand.val == un.val) {
            vn = cand;
            break;
          }
        }
        // Must exist
        assertTrue(vn != null, "Corresponding clone neighbor must exist");

        // First time seeing this original neighbor -> map it and enqueue
        if (!map.containsKey(un)) {
          map.put(un, vn);
          q.offer(un);
        } else {
          // If we've seen it, mapping should be consistent
          assertTrue(map.get(un) == vn, "Mapping must be consistent for repeated visits");
        }
      }
    }
  }

  @Test
  @DisplayName("Null input -> null output")
  void nullGraph() {
    CloneGraph sol = new CloneGraph();
    Node out = sol.cloneGraph(null);
    assertTrue(out == null);
  }

  @Test
  @DisplayName("Single node with no neighbors")
  void singleNode() {
    CloneGraph sol = new CloneGraph();
    Node a = new Node(1, new java.util.ArrayList<>());
    Node b = sol.cloneGraph(a);

    // Basic checks
    assertNotSame(a, b);
    assertEquals(1, b.val);
    assertTrue(b.neighbors.isEmpty());

    // Structural check
    assertGraphCloned(a, b);
  }

  @Test
  @DisplayName("Triangle cycle 1-2-3-1")
  void triangleCycle() {
    CloneGraph sol = new CloneGraph();

    Node n1 = new Node(1, new java.util.ArrayList<>());
    Node n2 = new Node(2, new java.util.ArrayList<>());
    Node n3 = new Node(3, new java.util.ArrayList<>());

    // Undirected edges: 1-2, 2-3, 3-1
    n1.neighbors.add(n2); n2.neighbors.add(n1);
    n2.neighbors.add(n3); n3.neighbors.add(n2);
    n3.neighbors.add(n1); n1.neighbors.add(n3);

    Node c1 = sol.cloneGraph(n1);
    assertGraphCloned(n1, c1);
  }

  @Test
  @DisplayName("Square 1-2-3-4-1 (cycle of length 4)")
  void squareCycle() {
    CloneGraph sol = new CloneGraph();

    Node n1 = new Node(1, new ArrayList<>());
    Node n2 = new Node(2, new ArrayList<>());
    Node n3 = new Node(3, new ArrayList<>());
    Node n4 = new Node(4, new ArrayList<>());

    // 1-2-3-4-1 (undirected)
    n1.neighbors.add(n2); n2.neighbors.add(n1);
    n2.neighbors.add(n3); n3.neighbors.add(n2);
    n3.neighbors.add(n4); n4.neighbors.add(n3);
    n4.neighbors.add(n1); n1.neighbors.add(n4);

    Node c1 = sol.cloneGraph(n1);
    assertGraphCloned(n1, c1);
  }
}
