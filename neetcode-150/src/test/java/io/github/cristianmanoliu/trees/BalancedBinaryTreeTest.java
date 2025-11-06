package io.github.cristianmanoliu.trees;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// JUnit 5 tests for BalancedBinaryTree
class BalancedBinaryTreeTest {

  // Helper: perfect small tree (balanced)
  //      2
  //     / \
  //    1   3
  private TreeNode perfectSmall() {
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(1);
    root.right = new TreeNode(3);
    return root;
  }

  // Helper: unbalanced left-heavy
  //        3
  //       /
  //      2
  //     /
  //    1
  private TreeNode leftHeavyChain() {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(1);
    return root;
  }

  // Helper: balanced but with depth difference exactly 1
  //        4
  //       / \
  //      2   6
  //     /
  //    1
  private TreeNode diffExactlyOne() {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.right = new TreeNode(6);
    root.left.left = new TreeNode(1);
    return root;
  }

  // Helper: unbalanced right-heavy deeper on one side
  //    1
  //     \
  //      2
  //       \
  //        3
  //       /
  //      4
  private TreeNode rightHeavyUnbalanced() {
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.right = new TreeNode(3);
    root.right.right.left = new TreeNode(4);
    return root;
  }

  @Test
  @DisplayName("Empty tree is balanced")
  void emptyTree() {
    BalancedBinaryTree sol = new BalancedBinaryTree();
    assertTrue(sol.isBalanced(null));
  }

  @Test
  @DisplayName("Perfect small tree is balanced")
  void perfectTreeBalanced() {
    BalancedBinaryTree sol = new BalancedBinaryTree();
    assertTrue(sol.isBalanced(perfectSmall()));
  }

  @Test
  @DisplayName("Left-heavy chain is unbalanced")
  void leftHeavyIsUnbalanced() {
    BalancedBinaryTree sol = new BalancedBinaryTree();
    assertFalse(sol.isBalanced(leftHeavyChain()));
  }

  @Test
  @DisplayName("Tree with height difference exactly 1 is balanced")
  void diffOneIsBalanced() {
    BalancedBinaryTree sol = new BalancedBinaryTree();
    assertTrue(sol.isBalanced(diffExactlyOne()));
  }

  @Test
  @DisplayName("Right-heavy deeper structure is unbalanced")
  void rightHeavyIsUnbalanced() {
    BalancedBinaryTree sol = new BalancedBinaryTree();
    assertFalse(sol.isBalanced(rightHeavyUnbalanced()));
  }
}