package io.github.cristianmanoliu.trees;

// https://neetcode.io/problems/count-good-nodes-in-binary-tree?list=neetcode150
// https://leetcode.com/problems/count-good-nodes-in-binary-tree/
public class CountGoodNodesInBinaryTree {

  // Main function: count "good" nodes in the tree.
  // A node is "good" if it is >= every value on the path from the root to that node.
  public int goodNodes(TreeNode root) {
    // Start DFS with the smallest possible max-so-far so the root always qualifies if it exists
    return dfs(root, Integer.MIN_VALUE);
  }

  // DFS helper that carries the maximum value seen so far along the current path.
  private int dfs(TreeNode node, int maxSoFar) {
    // Base case: empty subtree contributes 0 "good" nodes
    if (node == null) {
      return 0;
    }

    // Determine if the current node is "good" relative to the path maximum
    int isGoodNode = (node.val >= maxSoFar) ? 1 : 0;

    // Update the path maximum for children
    int nextMax = Math.max(maxSoFar, node.val);

    // Recurse on left and right subtrees and sum up "good" nodes
    return isGoodNode
        + dfs(node.left, nextMax)
        + dfs(node.right, nextMax);
  }
}
