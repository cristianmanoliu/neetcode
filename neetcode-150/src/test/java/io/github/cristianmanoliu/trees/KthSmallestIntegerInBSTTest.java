package io.github.cristianmanoliu.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class KthSmallestIntegerInBSTTest {

  // Helper: quick node constructor with children
  private TreeNode n(int v, TreeNode l, TreeNode r) {
    TreeNode t = new TreeNode(v);
    t.left = l;
    t.right = r;
    return t;
  }

  @Test
  @DisplayName("Example 1: simple BST")
  void example1() {
    KthSmallestIntegerInBST sol = new KthSmallestIntegerInBST();
    //     3
    //    / \
    //   1   4
    //    \
    //     2
    TreeNode root = n(3, n(1, null, new TreeNode(2)), new TreeNode(4));
    assertEquals(1, sol.kthSmallest(root, 1));
    assertEquals(2, sol.kthSmallest(root, 2));
    assertEquals(3, sol.kthSmallest(root, 3));
    assertEquals(4, sol.kthSmallest(root, 4));
  }

  @Test
  @DisplayName("Example 2: deeper BST")
  void example2() {
    KthSmallestIntegerInBST sol = new KthSmallestIntegerInBST();
    //         5
    //        / \
    //       3   6
    //      / \
    //     2   4
    //    /
    //   1
    TreeNode root = n(5,
        n(3, n(2, new TreeNode(1), null), new TreeNode(4)),
        new TreeNode(6));
    assertEquals(3, sol.kthSmallest(root, 3));
  }

  @Test
  @DisplayName("Single node tree")
  void singleNode() {
    KthSmallestIntegerInBST sol = new KthSmallestIntegerInBST();
    TreeNode root = new TreeNode(10);
    assertEquals(10, sol.kthSmallest(root, 1));
  }

  @Test
  @DisplayName("Larger BST with mixed structure")
  void largerMixed() {
    KthSmallestIntegerInBST sol = new KthSmallestIntegerInBST();
    //        8
    //       / \
    //      3   10
    //     / \    \
    //    1   6    14
    //       / \   /
    //      4   7 13
    TreeNode root = n(8,
        n(3, new TreeNode(1), n(6, new TreeNode(4), new TreeNode(7))),
        n(10, null, n(14, new TreeNode(13), null)));
    // Inorder: [1,3,4,6,7,8,10,13,14]
    assertEquals(7, sol.kthSmallest(root, 5)); // 5th smallest is 7
  }

  @Test
  @DisplayName("Degenerate BSTs (chains)")
  void degenerateChains() {
    KthSmallestIntegerInBST sol = new KthSmallestIntegerInBST();

    // Left chain: 3 <- 2 <- 1
    TreeNode left = n(3, n(2, new TreeNode(1), null), null);
    assertEquals(2, sol.kthSmallest(left, 2));

    // Right chain: 1 -> 2 -> 3
    TreeNode right = n(1, null, n(2, null, new TreeNode(3)));
    assertEquals(3, sol.kthSmallest(right, 3));
  }

  @Test
  @DisplayName("Repeated calls on the same instance should be independent")
  void repeatedCalls() {
    KthSmallestIntegerInBST sol = new KthSmallestIntegerInBST();
    TreeNode a = n(2, new TreeNode(1), new TreeNode(3));
    TreeNode b = n(5, n(3, new TreeNode(2), new TreeNode(4)), new TreeNode(6));

    assertEquals(2, sol.kthSmallest(a, 2));
    assertEquals(4, sol.kthSmallest(b, 3));
  }
}