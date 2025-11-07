package io.github.cristianmanoliu.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CountGoodNodesInBinaryTreeTest {

  // Helper: quick node constructor with children
  private TreeNode n(int v, TreeNode l, TreeNode r) {
    TreeNode t = new TreeNode(v);
    t.left = l;
    t.right = r;
    return t;
  }

  @Test
  @DisplayName("Empty tree -> 0 good nodes")
  void emptyTree() {
    CountGoodNodesInBinaryTree sol = new CountGoodNodesInBinaryTree();
    assertEquals(0, sol.goodNodes(null));
  }

  @Test
  @DisplayName("Single node -> 1 good node")
  void singleNode() {
    CountGoodNodesInBinaryTree sol = new CountGoodNodesInBinaryTree();
    assertEquals(1, sol.goodNodes(new TreeNode(5)));
  }

  @Test
  @DisplayName("LeetCode-style example: [3,1,4,3,null,1,5] -> 4")
  void exampleFromProblem() {
    CountGoodNodesInBinaryTree sol = new CountGoodNodesInBinaryTree();
    //        3
    //       / \
    //      1   4
    //     /   / \
    //    3   1   5
    TreeNode root = n(3,
        n(1, new TreeNode(3), null),
        n(4, new TreeNode(1), new TreeNode(5)));
    assertEquals(4, sol.goodNodes(root));
  }

  @Test
  @DisplayName("Strictly decreasing paths -> only the roots on each path are good")
  void strictlyDecreasing() {
    CountGoodNodesInBinaryTree sol = new CountGoodNodesInBinaryTree();
    //      5
    //     / \
    //    4   2
    //   /
    //  3
    TreeNode root = n(5, n(4, new TreeNode(3), null), new TreeNode(2));
    // Good: 5 only -> 1
    assertEquals(1, sol.goodNodes(root));
  }

  @Test
  @DisplayName("Handles negatives and equality (>= allowed)")
  void negativesAndEquality() {
    CountGoodNodesInBinaryTree sol = new CountGoodNodesInBinaryTree();
    //        -1
    //        / \
    //      -1  -2
    //      /
    //    -1
    TreeNode root = n(-1, n(-1, new TreeNode(-1), null), new TreeNode(-2));
    // Good nodes: root(-1), left(-1), left.left(-1) -> 3
    assertEquals(3, sol.goodNodes(root));
  }

  @Test
  @DisplayName("Increasing along a branch increases count")
  void increasingBranch() {
    CountGoodNodesInBinaryTree sol = new CountGoodNodesInBinaryTree();
    //     2
    //    /
    //   2
    //    \
    //     3
    TreeNode root = n(2, n(2, null, new TreeNode(3)), null);
    // Good: 2(root), 2(left child, equal), 3 (greater) -> 3
    assertEquals(3, sol.goodNodes(root));
  }
}