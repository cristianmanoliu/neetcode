package io.github.cristianmanoliu.trees;

// https://neetcode.io/problems/balanced-binary-tree?list=neetcode150
// https://leetcode.com/problems/balanced-binary-tree
public class BalancedBinaryTree {

  public boolean isBalanced(TreeNode root) {
    return heightOrUnbalanced(root) != -1;
  }

  // Returns height if subtree is balanced; otherwise returns -1
  private int heightOrUnbalanced(TreeNode node) {
    if (node == null) {
      return 0;
    }

    int hL = heightOrUnbalanced(node.left);
    if (hL == -1) {
      return -1; // left subtree unbalanced
    }

    int hR = heightOrUnbalanced(node.right);
    if (hR == -1) {
      return -1; // right subtree unbalanced
    }

    if (Math.abs(hL - hR) > 1) {
      return -1; // current node unbalanced
    }

    return 1 + Math.max(hL, hR);
  }
}