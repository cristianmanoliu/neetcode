package io.github.cristianmanoliu.trees;

import java.util.ArrayDeque;
import java.util.Queue;

// https://neetcode.io/problems/invert-a-binary-tree?list=neetcode150
// https://leetcode.com/problems/invert-binary-tree
public class InvertBinaryTree {

  // Iterative BFS (no 'seen' needed)
  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }

    Queue<TreeNode> q = new ArrayDeque<>();
    q.offer(root);

    while (!q.isEmpty()) {
      TreeNode cur = q.poll();

      // swap children
      TreeNode tmp = cur.left;
      cur.left = cur.right;
      cur.right = tmp;

      if (cur.left != null) {
        q.offer(cur.left);
      }
      if (cur.right != null) {
        q.offer(cur.right);
      }
    }
    return root;
  }
}
