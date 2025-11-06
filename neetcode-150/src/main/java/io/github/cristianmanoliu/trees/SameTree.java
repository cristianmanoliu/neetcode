package io.github.cristianmanoliu.trees;

// https://neetcode.io/problems/same-binary-tree?list=neetcode150
// https://leetcode.com/problems/same-tree
public class SameTree {

  // Main function: determine whether two binary trees are structurally identical
  // AND contain the same values at corresponding positions.
  public boolean isSameTree(TreeNode p, TreeNode q) {
    // Base cases:
    // - If either node is null, both must be null to be the same.
    if (p == null || q == null) {
      return p == q; // true only if both are null
    }

    // Recursive step:
    // - Current nodes must have the same value
    // - Left subtrees must be the same
    // - Right subtrees must be the same
    return p.val == q.val
        && isSameTree(p.left, q.left)
        && isSameTree(p.right, q.right);
  }
}