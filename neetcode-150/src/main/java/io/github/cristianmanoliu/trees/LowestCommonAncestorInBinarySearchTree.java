package io.github.cristianmanoliu.trees;

// https://neetcode.io/problems/lowest-common-ancestor-in-binary-search-tree?list=neetcode150
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
public class LowestCommonAncestorInBinarySearchTree {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    // We can assume all values are unique and p, q exist in the tree.
    int pVal = p.val;
    int qVal = q.val;

    TreeNode curr = root;
    // Traverse the tree.
    while (curr != null) {
      // Current node's value.
      int currVal = curr.val;

      // If both p and q are smaller than curr, LCA must be in the left subtree.
      if (pVal < currVal && qVal < currVal) {
        curr = curr.left;
      }
      // If both p and q are greater than curr, LCA must be in the right subtree.
      else if (pVal > currVal && qVal > currVal) {
        curr = curr.right;
      }
      // Otherwise, we have split (or one equals curr) → curr is the LCA.
      else {
        return curr;
      }
    }

    // According to the problem, this case should not occur (p and q are in the tree),
    // but we return null for completeness.
    return null;
  }
}
