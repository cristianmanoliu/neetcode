package io.github.cristianmanoliu.trees;

// https://neetcode.io/problems/subtree-of-a-binary-tree?list=neetcode150
// https://leetcode.com/problems/subtree-of-a-binary-tree
public class SubtreeOfAnotherTree {

  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    // Edge case: empty subRoot is always a subtree
    if (subRoot == null) {
      return true;
    }
    // If main tree is empty but subRoot is not, cannot be a subtree
    if (root == null) {
      return false;
    }

    // Check if the subtree rooted at this node matches subRoot,
    // or recurse into left and right children.
    if (isSameTree(root, subRoot)) {
      return true;
    }

    // Recur on left and right subtrees
    return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
  }

  private boolean isSameTree(TreeNode a, TreeNode b) {
    // Both nodes are null, trees match
    if (a == null && b == null) {
      return true;
    }
    // One node is null and the other is not, trees don't match
    if (a == null || b == null) {
      return false;
    }
    // Node values differ, trees don't match
    if (a.val != b.val) {
      return false;
    }

    // Recur on left and right children
    return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
  }
}
