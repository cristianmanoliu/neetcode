package io.github.cristianmanoliu.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// https://neetcode.io/problems/clone-graph?list=neetcode150
// https://leetcode.com/problems/clone-graph/
public class CloneGraph {

  public Node cloneGraph(Node node) {
    // Handle null input
    if (node == null) {
      return null;
    }

    Map<Node, Node> map = new HashMap<>();
    // Start DFS cloning from the given node
    return dfs(node, map);
  }

  private Node dfs(Node node, Map<Node, Node> map) {
    // If we've already cloned this node, return the clone
    if (map.containsKey(node)) {
      return map.get(node);
    }

    // Create a new clone for this node
    Node clone = new Node(node.val, new ArrayList<>());
    map.put(node, clone);

    // Recursively clone and attach neighbors
    for (Node nei : node.neighbors) {
      clone.neighbors.add(dfs(nei, map));
    }

    return clone;
  }
}