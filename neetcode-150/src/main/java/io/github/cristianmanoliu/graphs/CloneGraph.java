package io.github.cristianmanoliu.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// https://neetcode.io/problems/clone-graph?list=neetcode150
// https://leetcode.com/problems/clone-graph/
public class CloneGraph {

  // Main function: deep-clone an undirected graph given a reference node.
  // Strategy: DFS with a HashMap<Node, Node> to memoize already-cloned nodes.
  // - If node is null, return null.
  // - If node already cloned, return the cached clone (prevents infinite cycles).
  // - Otherwise clone current node, store in map, then recursively clone neighbors.
  public Node cloneGraph(Node node) {
    // Handle null input
    if (node == null) {
      return null;
    }

    // Map original -> cloned node to avoid re-cloning (and handle cycles)
    Map<Node, Node> map = new HashMap<>();
    // Start DFS cloning from the given node
    return dfs(node, map);
  }

  // DFS helper: returns the clone of 'node', using 'map' to memoize
  private Node dfs(Node node, Map<Node, Node> map) {
    // If we've already cloned this node, return the clone
    if (map.containsKey(node)) {
      return map.get(node);
    }

    // Create a new clone for this node (same value, empty neighbor list for now)
    Node clone = new Node(node.val, new ArrayList<>());
    map.put(node, clone); // memoize early to break cycles

    // Recursively clone and attach neighbors
    for (Node nei : node.neighbors) {
      clone.neighbors.add(dfs(nei, map));
    }

    return clone;
  }
}
