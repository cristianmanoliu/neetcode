package io.github.cristianmanoliu.trees;

// https://neetcode.io/problems/binary-tree-diameter?list=neetcode150
// https://leetcode.com/problems/diameter-of-binary-tree
public class DiameterOfBinaryTree {

  // Tracks the best (maximum) diameter found so far in EDGES.
  // Note: LeetCode defines diameter as number of EDGES on the longest path.
  private int best; // do not keep value between calls; reset in diameterOfBinaryTree

  // Main function: compute the diameter (in edges) of the binary tree.
  public int diameterOfBinaryTree(TreeNode root) {
    // Reset state for this invocation
    best = 0;
    // Fill 'best' while computing depths
    depth(root);
    return best;
  }

  // Helper: returns the height (in NODES) of the subtree rooted at 'node'.
  // While unwinding recursion, we update 'best' with leftHeight + rightHeight,
  // which equals the number of EDGES on the longest path passing through 'node'.
  private int depth(TreeNode node) {
    // Base case: empty subtree has height 0
    if (node == null) {
      return 0;
    }

    // Recursively compute left/right subtree heights (in nodes)
    int left = depth(node.left);
    int right = depth(node.right);

    // Candidate diameter through this node (in edges) = left + right
    best = Math.max(best, left + right);

    // Height (in nodes) contributed to parent = 1 (this node) + max(left, right)
    return Math.max(left, right) + 1;
  }
}