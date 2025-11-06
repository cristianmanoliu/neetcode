package io.github.cristianmanoliu.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// https://neetcode.io/problems/binary-tree-right-side-view?list=neetcode150
// https://leetcode.com/problems/binary-tree-right-side-view/
public class BinaryTreeRightSideView {

  // Main function: return the list of node values visible from the right side.
  // Idea: Do a BFS level-order traversal and record the LAST node at each level.
  public List<Integer> rightSideView(TreeNode root) {
    // Result list for rightmost values per level
    List<Integer> ans = new ArrayList<>();

    // Base case: empty tree => nothing visible
    if (root == null) {
      return ans;
    }

    // BFS queue seeded with the root
    Queue<TreeNode> q = new ArrayDeque<>();
    q.offer(root);

    // Process the tree level by level
    while (!q.isEmpty()) {
      // Capture the current level size (number of nodes at this depth)
      int size = q.size();

      // Iterate through all nodes of this level
      for (int i = 0; i < size; i++) {
        // Pop next node from the queue
        TreeNode cur = q.poll();

        // If this is the LAST node at this level, it's visible from the right
        if (i == size - 1) {
          ans.add(cur.val);
        }

        // Enqueue children for the next level (left first, then right)
        if (cur.left != null) {
          q.offer(cur.left);
        }
        if (cur.right != null) {
          q.offer(cur.right);
        }
      }
    }

    // Return the collected right-view values
    return ans;
  }
}