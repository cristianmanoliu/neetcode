package io.github.cristianmanoliu.trees;

import java.util.ArrayDeque;
import java.util.Deque;

// https://neetcode.io/problems/kth-smallest-integer-in-bst?list=neetcode150
// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
public class KthSmallestIntegerInBST {

  // Main function: return the k-th smallest value in a BST.
  // Strategy: Iterative in-order traversal (Left -> Node -> Right) using a stack.
  // In-order over a BST yields nodes in ascending order, so the k-th popped node is the answer.
  public int kthSmallest(TreeNode root, int k) {
    // Explicit stack to simulate recursion
    Deque<TreeNode> stack = new ArrayDeque<>();
    // Start traversal from the root
    TreeNode current = root;

    // Continue while there are nodes to visit or nodes on the stack
    while (current != null || !stack.isEmpty()) {
      // 1) Dive left as far as possible, pushing the path onto the stack
      while (current != null) {
        stack.push(current);
        current = current.left;
      }

      // 2) Visit the next node in ascending order
      current = stack.pop();

      // Decrement k; if it hits zero, we've reached the k-th smallest node
      if (--k == 0) {
        return current.val;
      }

      // 3) Explore the right subtree next
      current = current.right;
    }

    // Per problem constraints, k is valid; return a fallback for safety
    return -1;
  }
}