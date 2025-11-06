package io.github.cristianmanoliu.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// JUnit 5 tests for MaximumDepthOfBinaryTree
class MaximumDepthOfBinaryTreeTest {

  // Helper: quick node constructor with children
  private TreeNode n(int v, TreeNode l, TreeNode r) {
    TreeNode t = new TreeNode(v);
    t.left = l;
    t.right = r;
    return t;
  }

  @Test
  @DisplayName("Empty tree has depth 0")
  void emptyTree() {
    MaximumDepthOfBinaryTree sol = new MaximumDepthOfBinaryTree();
    assertEquals(0, sol.maxDepth(null));
  }

  @Test
  @DisplayName("Single node has depth 1")
  void singleNode() {
    MaximumDepthOfBinaryTree sol = new MaximumDepthOfBinaryTree();
    assertEquals(1, sol.maxDepth(new TreeNode(42)));
  }

  @Test
  @DisplayName("Balanced example: depth 3")
  void balancedExample() {
    MaximumDepthOfBinaryTree sol = new MaximumDepthOfBinaryTree();
    //      3
    //     / \
    //    9  20
    //       / \
    //      15  7
    TreeNode root = n(3, new TreeNode(9), n(20, new TreeNode(15), new TreeNode(7)));
    assertEquals(3, sol.maxDepth(root));
  }

  @Test
  @DisplayName("Left-skewed chain depth equals number of nodes")
  void leftSkewed() {
    MaximumDepthOfBinaryTree sol = new MaximumDepthOfBinaryTree();
    //   1
    //  /
    // 2
    // /
    //3
    TreeNode root = n(1, n(2, new TreeNode(3), null), null);
    assertEquals(3, sol.maxDepth(root));
  }

  @Test
  @DisplayName("Right-skewed chain depth equals number of nodes")
  void rightSkewed() {
    MaximumDepthOfBinaryTree sol = new MaximumDepthOfBinaryTree();
    // 1
    //  \
    //   2
    //    \
    //     3
    TreeNode root = n(1, null, n(2, null, new TreeNode(3)));
    assertEquals(3, sol.maxDepth(root));
  }

  @Test
  @DisplayName("Mixed tree with different subtree depths")
  void mixedTree() {
    MaximumDepthOfBinaryTree sol = new MaximumDepthOfBinaryTree();
    //        8
    //       / \
    //      3   10
    //     / \    \
    //    1   6    14
    //       / \   /
    //      4   7 13
    TreeNode root = n(8, n(3, new TreeNode(1), n(6, new TreeNode(4), new TreeNode(7))), n(10, null, n(14, new TreeNode(13), null)));
    // Longest path length = 4 (8->10->14->13 or 8->3->6->4/7)
    assertEquals(4, sol.maxDepth(root));
  }
}
