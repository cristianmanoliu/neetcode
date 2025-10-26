package io.github.cristianmanoliu.trees;

// https://neetcode.io/problems/depth-of-binary-tree?list=neetcode150
// https://leetcode.com/problems/maximum-depth-of-binary-tree
public class MaximumDepthOfBinaryTree {

  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int leftDepth = maxDepth(root.left);
    int rightDepth = maxDepth(root.right);

    return Math.max(leftDepth, rightDepth) + 1;
  }

}

