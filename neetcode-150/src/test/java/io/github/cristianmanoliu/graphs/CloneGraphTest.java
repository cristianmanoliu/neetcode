package io.github.cristianmanoliu.graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class CloneGraphTest {

  @Test
  void testCloneGraph() {
    // Create a sample graph
    Node node1 = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);
    Node node4 = new Node(4);

    node1.neighbors.add(node2);
    node1.neighbors.add(node4);
    node2.neighbors.add(node1);
    node2.neighbors.add(node3);
    node3.neighbors.add(node2);
    node3.neighbors.add(node4);
    node4.neighbors.add(node1);
    node4.neighbors.add(node3);

    CloneGraph cloneGraph = new CloneGraph();
    Node clonedNode = cloneGraph.cloneGraph(node1);

    // Verify the cloned graph structure
    assertNotNull(clonedNode);
    assertEquals(1, clonedNode.val);
    assertEquals(2, clonedNode.neighbors.size());

    Node clonedNode2 = clonedNode.neighbors.get(0);
    Node clonedNode4 = clonedNode.neighbors.get(1);

    assertEquals(2, clonedNode2.val);
    assertEquals(4, clonedNode4.val);

    assertEquals(2, clonedNode2.neighbors.size());
    assertEquals(2, clonedNode4.neighbors.size());

    Node clonedNode3 = clonedNode2.neighbors.stream()
        .filter(n -> n.val == 3)
        .findFirst()
        .orElse(null);

    assertNotNull(clonedNode3);
    assertEquals(3, clonedNode3.val);
  }

}