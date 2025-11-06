package io.github.cristianmanoliu.trees;

// https://neetcode.io/problems/binary-tree-maximum-path-sum?list=neetcode150
// https://leetcode.com/problems/binary-tree-maximum-path-sum/
public class BinaryTreeMaximumPathSum {

  // Global variable to keep track of the maximum path sum across the whole tree.
  // A "path" can start and end at any two nodes, but it must be continuous
  // (move only through parent-child edges) and cannot reuse a node.
  private int maxSum;

  // Main function to calculate the maximum path sum in the tree.
  public int maxPathSum(TreeNode root) {
    // Initialize with the smallest integer to handle all-negative trees.
    maxSum = Integer.MIN_VALUE;
    // Fill maxSum by exploring gains from every node.
    maxGain(root);
    return maxSum;
  }

  // Returns the maximum "gain" that this node can contribute to its parent:
  // node.val + max(0, best child gain). A negative child path is discarded (treated as 0).
  private int maxGain(TreeNode node) {
    // Base case: null contributes 0 gain upward.
    if (node == null) {
      return 0;
    }

    // Recursively compute gains from left and right subtrees.
    // If a gain is negative, we clamp it to 0 to avoid decreasing the path sum.
    int leftGain = Math.max(0, maxGain(node.left));
    int rightGain = Math.max(0, maxGain(node.right));

    // Path "through" the current node that potentially uses both children.
    int throughNode = node.val + leftGain + rightGain;

    // Update the global maximum with any path that passes through this node.
    maxSum = Math.max(maxSum, throughNode);

    // Contribution to parent: node plus the better of its two sides.
    return node.val + Math.max(leftGain, rightGain);
  }
}