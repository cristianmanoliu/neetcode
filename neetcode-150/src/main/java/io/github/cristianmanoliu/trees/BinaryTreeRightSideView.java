package io.github.cristianmanoliu.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// https://neetcode.io/problems/binary-tree-right-side-view?list=neetcode150
// https://leetcode.com/problems/binary-tree-right-side-view/
public class BinaryTreeRightSideView {

  public List<Integer> rightSideView(TreeNode root) {
    // Result list
    List<Integer> ans = new ArrayList<>();
    // Edge case: empty tree
    if (root == null) {
      return ans;
    }

    // BFS queue
    Queue<TreeNode> q = new ArrayDeque<>();
    // Start with the root
    q.offer(root);

    // Level-order traversal
    while (!q.isEmpty()) {
      // Number of nodes at the current level
      int size = q.size();
      // Process all nodes at this level
      for (int i = 0; i < size; i++) {
        // Get the next node
        TreeNode cur = q.poll();
        // If it's the rightmost node at this level, add to result
        // i == size - 1 means it's the last node in this level
        if (i == size - 1) {
          // Add its value to the answer
          ans.add(cur.val);
        }
        // Add child nodes to the queue for the next level
        // Add left child first
        if (cur.left != null) {
          q.offer(cur.left);
        }
        // Add right child second
        if (cur.right != null) {
          q.offer(cur.right);
        }
      }
    }
    // Return the list of rightmost values
    return ans;
  }
}
