package io.github.cristianmanoliu.trees;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidBinarySearchTreeTest {

  // Helper: quick node constructor with children
  private TreeNode n(int v, TreeNode l, TreeNode r) {
    TreeNode t = new TreeNode(v);
    t.left = l;
    t.right = r;
    return t;
  }

  @Test
  @DisplayName("Empty tree is a valid BST")
  void emptyTree() {
    ValidBinarySearchTree sol = new ValidBinarySearchTree();
    assertTrue(sol.isValidBST(null));
  }

  @Test
  @DisplayName("Single node is a valid BST")
  void singleNode() {
    ValidBinarySearchTree sol = new ValidBinarySearchTree();
    assertTrue(sol.isValidBST(new TreeNode(7)));
  }

  @Test
  @DisplayName("Simple valid BST [2,1,3]")
  void simpleValid() {
    ValidBinarySearchTree sol = new ValidBinarySearchTree();
    TreeNode root = n(2, new TreeNode(1), new TreeNode(3));
    assertTrue(sol.isValidBST(root));
  }

  @Test
  @DisplayName("Duplicates violate strict BST ordering")
  void duplicatesInvalid() {
    ValidBinarySearchTree sol = new ValidBinarySearchTree();
    // Left duplicate
    TreeNode leftDup = n(2, new TreeNode(2), new TreeNode(3));
    assertFalse(sol.isValidBST(leftDup));
    // Right duplicate
    TreeNode rightDup = n(2, new TreeNode(1), new TreeNode(2));
    assertFalse(sol.isValidBST(rightDup));
  }

  @Test
  @DisplayName("Classic invalid: right subtree contains a smaller value")
  void classicInvalid() {
    ValidBinarySearchTree sol = new ValidBinarySearchTree();
    //      5
    //     / \
    //    1   4
    //       / \
    //      3   6
    TreeNode root = n(5, new TreeNode(1), n(4, new TreeNode(3), new TreeNode(6)));
    assertFalse(sol.isValidBST(root));
  }

  @Test
  @DisplayName("Bounds near Integer limits should pass with long guard rails")
  void minMaxBounds() {
    ValidBinarySearchTree sol = new ValidBinarySearchTree();
    TreeNode root = n(0, new TreeNode(Integer.MIN_VALUE), new TreeNode(Integer.MAX_VALUE));
    assertTrue(sol.isValidBST(root));
  }

  @Test
  @DisplayName("Valid skewed chains")
  void skewedValid() {
    ValidBinarySearchTree sol = new ValidBinarySearchTree();
    // Left-skewed decreasing: 3 <- 2 <- 1
    TreeNode left = n(3, n(2, new TreeNode(1), null), null);
    assertTrue(sol.isValidBST(left));
    // Right-skewed increasing: 1 -> 2 -> 3
    TreeNode right = n(1, null, n(2, null, new TreeNode(3)));
    assertTrue(sol.isValidBST(right));
  }

  @Test
  @DisplayName("Deep violation inside right subtree")
  void deepViolation() {
    ValidBinarySearchTree sol = new ValidBinarySearchTree();
    //        10
    //       /  \
    //      5    15
    //          /  \
    //         6    20   <-- 6 violates because it is <= 10 but in right subtree of 10
    TreeNode root = n(10, new TreeNode(5), n(15, new TreeNode(6), new TreeNode(20)));
    assertFalse(sol.isValidBST(root));
  }
}
