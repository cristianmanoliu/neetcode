package io.github.cristianmanoliu.trees;

// https://neetcode.io/problems/count-good-nodes-in-binary-tree?list=neetcode150
// https://leetcode.com/problems/count-good-nodes-in-binary-tree/
public class CountGoodNodesInBinaryTree {

  public int goodNodes(TreeNode root) {
    return dfs(root, Integer.MIN_VALUE);
  }

  private int dfs(TreeNode node, int maxSoFar) {
    // Base case
    if (node == null) {
      return 0;
    }
    // Check if current node is a good node
    int isGoodNode = (node.val >= maxSoFar) ? 1 : 0;
    // Update the max value for the path
    int nextMax = Math.max(maxSoFar, node.val);
    // Recurse on left and right subtrees and sum up the good nodes
    return isGoodNode + dfs(node.left, nextMax) + dfs(node.right, nextMax);
  }
}
