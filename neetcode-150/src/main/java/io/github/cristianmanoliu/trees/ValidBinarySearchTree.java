package io.github.cristianmanoliu.trees;

// https://neetcode.io/problems/valid-binary-search-tree?list=neetcode150
// https://leetcode.com/problems/validate-binary-search-tree/
public class ValidBinarySearchTree {

  // Main function: validate that the binary tree satisfies BST rules.
  // Strategy: DFS carrying a valid range (low, high). Each node must be strictly between them.
  // We use 'long' bounds to safely compare around Integer.MIN_VALUE / Integer.MAX_VALUE.
  public boolean isValidBST(TreeNode root) {
    return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  // Helper: node must satisfy (low < node.val < high), and its children inherit tightened ranges:
  // left child -> (low, node.val), right child -> (node.val, high).
  private boolean validate(TreeNode node, long low, long high) {
    // Base case: empty subtree is valid
    if (node == null) {
      return true;
    }
    // Current node must lie strictly inside the allowed range
    if (node.val <= low || node.val >= high) {
      return false;
    }
    // Recurse on children with updated bounds
    return validate(node.left, low, node.val) && validate(node.right, node.val, high);
  }
}
