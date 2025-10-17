package io.github.cristianmanoliu.trees;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

// https://neetcode.io/problems/invert-a-binary-tree?list=neetcode150
public class InvertBinaryTree {

  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }

    Set<TreeNode> seen = new HashSet<>();
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      TreeNode current = queue.poll();
      TreeNode temp = current.left;
      current.left = current.right;
      current.right = temp;

      if (current.left != null && !seen.contains(current.left)) {
        queue.offer(current.left);
        seen.add(current.left);
      }
      if (current.right != null && !seen.contains(current.right)) {
        queue.offer(current.right);
        seen.add(current.right);
      }
    }

    return root;
  }
}
