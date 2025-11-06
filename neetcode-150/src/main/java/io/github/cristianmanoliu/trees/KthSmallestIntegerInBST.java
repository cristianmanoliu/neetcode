package io.github.cristianmanoliu.trees;

import java.util.ArrayDeque;
import java.util.Deque;

// https://neetcode.io/problems/kth-smallest-integer-in-bst?list=neetcode150
// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
public class KthSmallestIntegerInBST {

  public int kthSmallest(TreeNode root, int k) {
    // iterative inorder traversal
    Deque<TreeNode> st = new ArrayDeque<>();
    // current node pointer
    TreeNode cur = root;

    // iterate until we find the kth smallest
    while (cur != null || !st.isEmpty()) {
      // go all the way left
      while (cur != null) {
        // push current node to stack
        st.push(cur);
        // move to left child
        cur = cur.left;
      }
      // pop from stack
      cur = st.pop();      // next smallest
      // decrement k
      if (--k == 0) {
        return cur.val;
      }
      // move to right child
      cur = cur.right;     // then explore right subtree
    }

    // per problem constraints k is valid; fallback for safety
    return -1;
  }
}
