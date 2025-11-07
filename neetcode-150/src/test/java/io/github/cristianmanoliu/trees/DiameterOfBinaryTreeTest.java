package io.github.cristianmanoliu.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DiameterOfBinaryTreeTest {

  // Helper: quick constructor with children
  private TreeNode n(int v, TreeNode l, TreeNode r) {
    TreeNode t = new TreeNode(v);
    t.left = l;
    t.right = r;
    return t;
  }

  @Test
  @DisplayName("Empty tree -> diameter 0")
  void emptyTree() {
    DiameterOfBinaryTree sol = new DiameterOfBinaryTree();
    assertEquals(0, sol.diameterOfBinaryTree(null));
  }

  @Test
  @DisplayName("Single node -> diameter 0")
  void singleNode() {
    DiameterOfBinaryTree sol = new DiameterOfBinaryTree();
    TreeNode root = new TreeNode(1);
    assertEquals(0, sol.diameterOfBinaryTree(root));
  }

  @Test
  @DisplayName("Two nodes -> diameter 1")
  void twoNodes() {
    DiameterOfBinaryTree sol = new DiameterOfBinaryTree();
    TreeNode root = n(1, new TreeNode(2), null);
    assertEquals(1, sol.diameterOfBinaryTree(root));
  }

  @Test
  @DisplayName("Three-node chain -> diameter 2")
  void chainThree() {
    DiameterOfBinaryTree sol = new DiameterOfBinaryTree();
    // 3
    // |
    // 2
    // |
    // 1
    TreeNode root = n(3, n(2, new TreeNode(1), null), null);
    assertEquals(2, sol.diameterOfBinaryTree(root));
  }

  @Test
  @DisplayName("Balanced-ish tree, diameter passes through root")
  void balancedTree() {
    DiameterOfBinaryTree sol = new DiameterOfBinaryTree();
    //       1
    //      / \
    //     2   3
    //    / \
    //   4   5
    //  / \
    // 6   7
    TreeNode root = n(1,
        n(2,
            n(4, new TreeNode(6), new TreeNode(7)),
            new TreeNode(5)),
        new TreeNode(3));
    // Longest path: 6-4-2-1-3 -> 4 edges
    assertEquals(4, sol.diameterOfBinaryTree(root));
  }

  @Test
  @DisplayName("State resets across calls on the same instance")
  void resetsAcrossCalls() {
    DiameterOfBinaryTree sol = new DiameterOfBinaryTree();

    TreeNode a = n(1, new TreeNode(2), null); // diameter = 1
    TreeNode b = n(1,
        n(2, n(4, new TreeNode(6), null), new TreeNode(5)),
        new TreeNode(3)); // diameter = 4 (6-4-2-1-3)

    assertEquals(1, sol.diameterOfBinaryTree(a));
    assertEquals(4, sol.diameterOfBinaryTree(b)); // must not be affected by previous call
  }
}
