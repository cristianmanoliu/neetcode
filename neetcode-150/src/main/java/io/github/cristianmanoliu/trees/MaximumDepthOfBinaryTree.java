package io.github.cristianmanoliu.trees;

// https://neetcode.io/problems/depth-of-binary-tree?list=neetcode150
// https://leetcode.com/problems/maximum-depth-of-binary-tree
public class MaximumDepthOfBinaryTree {

  // Main function: compute the maximum depth (height in nodes) of a binary tree.
  // Strategy: Recursive DFS. The depth of a node is 1 + max(depth(left), depth(right)).
  public int maxDepth(TreeNode root) {
    // Base case: an empty subtree has depth 0
    if (root == null) {
      return 0;
    }

    // Recursively compute the depths of left and right subtrees
    int leftDepth = maxDepth(root.left);
    int rightDepth = maxDepth(root.right);

    // Current node's depth is 1 (for this node) plus the larger child depth
    return Math.max(leftDepth, rightDepth) + 1;
  }
}