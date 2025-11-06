package io.github.cristianmanoliu.trees;

// https://neetcode.io/problems/binary-tree-maximum-path-sum?list=neetcode150
// https://leetcode.com/problems/binary-tree-maximum-path-sum/
public class BinaryTreeMaximumPathSum {

  // Global variable to keep track of the maximum path sum
  private int maxSum;

  // Main function to calculate the maximum path sum
  public int maxPathSum(TreeNode root) {
    maxSum = Integer.MIN_VALUE;
    maxGain(root);
    return maxSum;
  }

  private int maxGain(TreeNode node) {
    // Base case
    if (node == null) {
      return 0;
    }

    // Recursively get the maximum gain from left and right subtrees
    // Ignore negative gains by taking max with 0
    int leftGain = Math.max(0, maxGain(node.left));
    int rightGain = Math.max(0, maxGain(node.right));

    // Calculate the maximum path sum passing through the current node
    int throughNode = node.val + leftGain + rightGain;
    // Update the global maximum path sum if needed
    maxSum = Math.max(maxSum, throughNode);
    // Return the maximum gain to the parent node
    return node.val + Math.max(leftGain, rightGain);
  }
}
