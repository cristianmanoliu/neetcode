package io.github.cristianmanoliu.trees;

import java.util.ArrayDeque;
import java.util.Deque;

// https://neetcode.io/problems/kth-smallest-integer-in-bst?list=neetcode150
// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
public class KthSmallestIntegerInBST {

  public int kthSmallest(TreeNode root, int k) {
    // In-order traversal using iterative approach with a stack
    Deque<TreeNode> stack = new ArrayDeque<>();
    // Start from the root node
    TreeNode current = root;
    // Traverse the tree
    while (current != null || !stack.isEmpty()) {
      // Go to the leftmost node
      while (current != null) {
        stack.push(current);
        current = current.left;
      }
      // Process the node from the stack
      current = stack.pop();
      // Decrement k and check if it's the kth smallest
      if (--k == 0) {
        // Found the kth smallest element
        return current.val;
      }
      // Move to the right subtree
      current = current.right;
    }

    return -1;
  }
}
