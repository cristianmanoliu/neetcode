package io.github.cristianmanoliu.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// JUnit 5 tests for BinaryTreeMaximumPathSum
class BinaryTreeMaximumPathSumTest {

  // Helper to quickly make a node with children.
  private TreeNode n(int val, TreeNode l, TreeNode r) {
    TreeNode t = new TreeNode(val);
    t.left = l;
    t.right = r;
    return t;
  }

  @Test
  @DisplayName("Single positive node returns its value")
  void singlePositiveNode() {
    BinaryTreeMaximumPathSum sol = new BinaryTreeMaximumPathSum();
    TreeNode root = new TreeNode(42);
    assertEquals(42, sol.maxPathSum(root));
  }

  @Test
  @DisplayName("Single negative node returns its value")
  void singleNegativeNode() {
    BinaryTreeMaximumPathSum sol = new BinaryTreeMaximumPathSum();
    TreeNode root = new TreeNode(-3);
    assertEquals(-3, sol.maxPathSum(root));
  }

  @Test
  @DisplayName("LeetCode example: [1,2,3] -> 6")
  void example123() {
    BinaryTreeMaximumPathSum sol = new BinaryTreeMaximumPathSum();
    //     1
    //    / \
    //   2   3
    TreeNode root = n(1, new TreeNode(2), new TreeNode(3));
    assertEquals(6, sol.maxPathSum(root));
  }

  @Test
  @DisplayName("LeetCode example: [-10,9,20,null,null,15,7] -> 42")
  void exampleNeg10() {
    BinaryTreeMaximumPathSum sol = new BinaryTreeMaximumPathSum();
    //        -10
    //        /  \
    //       9    20
    //           /  \
    //         15    7
    TreeNode root = n(-10, new TreeNode(9), n(20, new TreeNode(15), new TreeNode(7)));
    assertEquals(42, sol.maxPathSum(root));
  }

  @Test
  @DisplayName("All negative values: best is the least negative single node")
  void allNegative() {
    BinaryTreeMaximumPathSum sol = new BinaryTreeMaximumPathSum();
    //     -3
    //     / \
    //   -2  -5
    TreeNode root = n(-3, new TreeNode(-2), new TreeNode(-5));
    // Best path is the single node -2
    assertEquals(-2, sol.maxPathSum(root));
  }

  @Test
  @DisplayName("Increasing chain 1->2->3->4 returns sum of the chain (10)")
  void increasingChain() {
    BinaryTreeMaximumPathSum sol = new BinaryTreeMaximumPathSum();
    // 1
    //  \
    //   2
    //    \
    //     3
    //      \
    //       4
    TreeNode root = n(1, null, n(2, null, n(3, null, new TreeNode(4))));
    assertEquals(10, sol.maxPathSum(root));
  }

  @Test
  @DisplayName("Picking to drop a negative child: [2,-1] -> 2")
  void dropNegativeChild() {
    BinaryTreeMaximumPathSum sol = new BinaryTreeMaximumPathSum();
    //   2
    //  /
    // -1
    TreeNode root = n(2, new TreeNode(-1), null);
    assertEquals(2, sol.maxPathSum(root));
  }
}