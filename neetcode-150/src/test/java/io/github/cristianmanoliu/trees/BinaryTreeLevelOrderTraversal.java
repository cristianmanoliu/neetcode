package io.github.cristianmanoliu.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// https://neetcode.io/problems/level-order-traversal-of-binary-tree?list=neetcode150
// https://leetcode.com/problems/binary-tree-level-order-traversal/
public class BinaryTreeLevelOrderTraversal {

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    // Edge case: empty tree.
    if (root == null) {
      return result;
    }

    // BFS using a queue.
    Queue<TreeNode> queue = new ArrayDeque<>();
    // Start with the root node.
    queue.offer(root);

    // While there are nodes to process.
    while (!queue.isEmpty()) {
      // Number of nodes at the current level.
      int levelSize = queue.size();
      // List to hold the current level's values.
      List<Integer> level = new ArrayList<>(levelSize);
      // Process all nodes at the current level.
      for (int i = 0; i < levelSize; i++) {
        // Dequeue the next node.
        TreeNode node = queue.poll();
        // Add its value to the current level list.
        level.add(node.val);
        // Enqueue left and right children if they exist.
        if (node.left != null) {
          queue.offer(node.left);
        }
        // Enqueue right child.
        if (node.right != null) {
          queue.offer(node.right);
        }
      }
      // Add the current level to the result.
      result.add(level);
    }
    // Return the list of levels.
    return result;
  }
}
