package io.github.cristianmanoliu.trees;

// https://neetcode.io/problems/lowest-common-ancestor-in-binary-search-tree?list=neetcode150
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
public class LowestCommonAncestorInBinarySearchTree {

  // Main function: find the Lowest Common Ancestor (LCA) of nodes p and q in a BST.
  // Because it's a BST, we can decide where to go by comparing values:
  // - If both targets are < current, go left.
  // - If both targets are > current, go right.
  // - Otherwise (they split, or one equals current), current is the LCA.
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    // We can assume all values are unique and p, q exist in the tree (per problem statement).
    int pVal = p.val;
    int qVal = q.val;

    // Start traversal from the root.
    TreeNode curr = root;

    // Traverse until we find the split point (or exact match).
    while (curr != null) {
      // Current node's value for quick reuse.
      int currVal = curr.val;

      // If both p and q are smaller than curr, LCA must lie in the left subtree.
      if (pVal < currVal && qVal < currVal) {
        curr = curr.left; // move left
      }
      // If both p and q are greater than curr, LCA must lie in the right subtree.
      else if (pVal > currVal && qVal > currVal) {
        curr = curr.right; // move right
      }
      // Otherwise, we have split (or one is exactly curr) → curr is the LCA.
      else {
        return curr;
      }
    }

    // Should not happen if p and q are guaranteed to be in the tree; return null for completeness.
    return null;
  }
}
