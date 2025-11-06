package io.github.cristianmanoliu.trees;

// https://neetcode.io/problems/balanced-binary-tree?list=neetcode150
// https://leetcode.com/problems/balanced-binary-tree
public class BalancedBinaryTree {

  // Main function to determine if a binary tree is height-balanced.
  // A binary tree is balanced if for every node, the height difference between
  // its left and right subtrees is at most 1.
  public boolean isBalanced(TreeNode root) {
    // We use a sentinel approach: compute subtree heights, but return -1 immediately
    // if any subtree is found unbalanced. If the final result is not -1, it's balanced.
    return heightOrUnbalanced(root) != -1;
  }

  // Helper that returns the height of the subtree if it is balanced; otherwise returns -1.
  // Height of a null node is 0.
  private int heightOrUnbalanced(TreeNode node) {
    // Base case: empty subtree has height 0
    if (node == null) {
      return 0;
    }

    // Recursively compute left subtree height
    int hL = heightOrUnbalanced(node.left);
    if (hL == -1) {
      // Left subtree already unbalanced; bubble up -1
      return -1;
    }

    // Recursively compute right subtree height
    int hR = heightOrUnbalanced(node.right);
    if (hR == -1) {
      // Right subtree already unbalanced; bubble up -1
      return -1;
    }

    // If current node's subtrees differ in height by more than 1, it's unbalanced
    if (Math.abs(hL - hR) > 1) {
      return -1;
    }

    // Otherwise, return this node's height = 1 + max(leftHeight, rightHeight)
    return 1 + Math.max(hL, hR);
  }
}
