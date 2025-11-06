package io.github.cristianmanoliu.trees;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ConstructBinaryTreeFromPreorderAndInorderTraversalTest {

  @Test
  void buildTree() {
    ConstructBinaryTreeFromPreorderAndInorderTraversal solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal();

    // Test case 1
    int[] preorder1 = {3, 9, 20, 15, 7};
    int[] inorder1 = {9, 3, 15, 20, 7};
    TreeNode expected1 = new TreeNode(3);
    expected1.left = new TreeNode(9);
    expected1.right = new TreeNode(20);
    expected1.right.left = new TreeNode(15);
    expected1.right.right = new TreeNode(7);
    TreeNode result1 = solution.buildTree(preorder1, inorder1);
    assertTrue(areTreesEqual(expected1, result1));

    // Test case 2
    int[] preorder2 = {-1};
    int[] inorder2 = {-1};
    TreeNode expected2 = new TreeNode(-1);
    TreeNode result2 = solution.buildTree(preorder2, inorder2);
    assertTrue(areTreesEqual(expected2, result2));
  }

  private boolean areTreesEqual(TreeNode left, TreeNode right) {
    if (left == null && right == null) {
      return true;
    }
    if (left == null || right == null) {
      return false;
    }
    if (left.val != right.val) {
      return false;
    }
    return areTreesEqual(left.left, right.left) && areTreesEqual(left.right, right.right);
  }
}