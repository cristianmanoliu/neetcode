package io.github.cristianmanoliu.trees;

// https://neetcode.io/problems/binary-tree-diameter?list=neetcode150
// https://leetcode.com/problems/diameter-of-binary-tree
public class DiameterOfBinaryTree {

  private int best = 0; // tracks the maximum number of edges on any path

  public int diameterOfBinaryTree(TreeNode root) {
    depth(root);
    return best;
  }

  // Returns height (in edges) from this node down to its deepest leaf.
  // We can also define height in nodes; using edges keeps diameter consistent with LeetCode's definition.
  private int depth(TreeNode node) {
    if (node == null) {
      return 0;
    }

    int left = depth(node.left);
    int right = depth(node.right);

    // Path through this node = left + right (number of edges on the longest left path + right path)
    best = Math.max(best, left + right);

    // Height of this node = 1 edge down to its child plus the taller child
    return Math.max(left, right) + 1;
  }
}
