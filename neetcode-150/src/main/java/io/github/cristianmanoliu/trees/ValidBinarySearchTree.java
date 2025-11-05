package io.github.cristianmanoliu.trees;

// https://neetcode.io/problems/valid-binary-search-tree?list=neetcode150
// https://leetcode.com/problems/validate-binary-search-tree/
public class ValidBinarySearchTree {

  public boolean isValidBST(TreeNode root) {
    return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  private boolean validate(TreeNode node, long low, long high) {
    // Base case
    if (node == null) {
      return true;
    }
    // Check current node value against bounds
    // It must be strictly greater than low and strictly less than high to maintain BST properties
    if (node.val <= low || node.val >= high) {
      return false;
    }
    // Recursively validate left and right subtrees with updated bounds
    return validate(node.left, low, node.val) && validate(node.right, node.val, high);
  }
}
