package io.github.cristianmanoliu.trees;

// https://neetcode.io/problems/binary-tree-diameter?list=neetcode150
// https://leetcode.com/problems/diameter-of-binary-tree
public class DiameterOfBinaryTree {

  private int best; // do not initialize here; reset per-call

  public int diameterOfBinaryTree(TreeNode root) {
    best = 0; // <-- reset state for this invocation
    depth(root);
    return best;
  }

  // Returns height in NODES from this node to deepest descendant.
  // Using node-count heights + (left + right) -> diameter in EDGES (LeetCode's definition).
  private int depth(TreeNode node) {
    if (node == null) {
      return 0;
    }

    int left = depth(node.left);
    int right = depth(node.right);

    best = Math.max(best, left + right); // path through node in edges
    return Math.max(left, right) + 1;    // height in nodes
  }
}
