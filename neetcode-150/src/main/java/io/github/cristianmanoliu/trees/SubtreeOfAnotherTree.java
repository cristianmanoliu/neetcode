package io.github.cristianmanoliu.trees;

// https://neetcode.io/problems/subtree-of-a-binary-tree?list=neetcode150
// https://leetcode.com/problems/subtree-of-a-binary-tree
public class SubtreeOfAnotherTree {

  // Main function: determine whether 'subRoot' is a subtree of 'root'.
  // Strategy:
  // - An empty tree (subRoot == null) is always a subtree.
  // - Otherwise, at each node of 'root', check if the subtree starting here
  //   exactly matches 'subRoot' (via isSameTree). If not, recurse left or right.
  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    // Edge case: empty subRoot is always a subtree
    if (subRoot == null) {
      return true;
    }
    // If main tree is empty but subRoot is not, cannot be a subtree
    if (root == null) {
      return false;
    }

    // If the current root matches subRoot, we are done
    if (isSameTree(root, subRoot)) {
      return true;
    }

    // Otherwise, try to find subRoot in either subtree
    return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
  }

  // Helper: check structural and value equality of two trees.
  private boolean isSameTree(TreeNode a, TreeNode b) {
    // Both nodes null -> trees match here
    if (a == null && b == null) {
      return true;
    }
    // One null and the other not -> mismatch
    if (a == null || b == null) {
      return false;
    }
    // Values must match and both subtrees must match
    if (a.val != b.val) {
      return false;
    }
    return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
  }
}
