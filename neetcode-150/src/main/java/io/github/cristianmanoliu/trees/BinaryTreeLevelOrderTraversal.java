package io.github.cristianmanoliu.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// https://neetcode.io/problems/level-order-traversal-of-binary-tree?list=neetcode150
// https://leetcode.com/problems/binary-tree-level-order-traversal/
public class BinaryTreeLevelOrderTraversal {

  // Main function: return a list of levels (each level is a list of node values).
  // Strategy: Do a BFS (level-order) with a queue. For each level, read the queue's
  // current size (that's the level size), pop exactly that many nodes, collect values,
  // and enqueue their non-null children to form the next level.
  public List<List<Integer>> levelOrder(TreeNode root) {
    // Output container: result.get(d) holds the list of values at depth d
    List<List<Integer>> result = new ArrayList<>();

    // Base case: empty tree => no levels to return
    if (root == null) {
      return result;
    }

    // BFS queue seeded with the root node
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);

    // Process nodes level by level until the queue is empty
    while (!queue.isEmpty()) {
      // Number of nodes in the current level
      int levelSize = queue.size();

      // Collect values for this level (pre-size for small perf win)
      List<Integer> level = new ArrayList<>(levelSize);

      // Pop exactly 'levelSize' nodes to process this level fully
      for (int i = 0; i < levelSize; i++) {
        // Dequeue next node for this level
        TreeNode node = queue.poll();

        // Record its value in the current level list
        level.add(node.val);

        // Enqueue children (if present) for the next level
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
      }

      // Append the completed level to the result
      result.add(level);
    }

    // Return the list of all levels from top to bottom
    return result;
  }
}
