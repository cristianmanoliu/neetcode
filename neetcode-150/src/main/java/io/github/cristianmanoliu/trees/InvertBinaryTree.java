package io.github.cristianmanoliu.trees;

import java.util.ArrayDeque;
import java.util.Queue;

// https://neetcode.io/problems/invert-a-binary-tree?list=neetcode150
// https://leetcode.com/problems/invert-binary-tree
public class InvertBinaryTree {

  // Main function: invert a binary tree (mirror it around its root).
  // Strategy: Iterative BFS. For each visited node, swap its left/right children,
  // then enqueue the (now swapped) non-null children to continue the process level by level.
  public TreeNode invertTree(TreeNode root) {
    // Base case: empty tree has nothing to invert
    if (root == null) {
      return null;
    }

    // BFS queue seeded with the root
    Queue<TreeNode> q = new ArrayDeque<>();
    q.offer(root);

    // Level-order traversal to swap children of every node
    while (!q.isEmpty()) {
      // Dequeue next node to process
      TreeNode cur = q.poll();

      // Swap its left and right children (mirror at this node)
      TreeNode tmp = cur.left;
      cur.left = cur.right;
      cur.right = tmp;

      // Enqueue the children (if present) to process their subtrees next
      if (cur.left != null) {
        q.offer(cur.left);
      }
      if (cur.right != null) {
        q.offer(cur.right);
      }
    }

    // Return the root of the now-inverted tree
    return root;
  }
}
