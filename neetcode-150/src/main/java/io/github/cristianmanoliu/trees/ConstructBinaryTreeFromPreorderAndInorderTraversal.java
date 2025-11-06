package io.github.cristianmanoliu.trees;

import java.util.HashMap;
import java.util.Map;

// https://neetcode.io/problems/binary-tree-from-preorder-and-inorder-traversal?list=neetcode150
// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

  // Main function: build a binary tree from preorder and inorder traversals.
  // Assumption: all node values are unique (per problem statement).
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    // Edge cases: null/empty or mismatched lengths
    if (preorder == null || inorder == null || preorder.length != inorder.length || preorder.length == 0) {
      return null;
    }

    // Map each value from inorder traversal to its index for O(1) splits
    Map<Integer, Integer> inIndex = new HashMap<>(inorder.length * 2);
    for (int i = 0; i < inorder.length; i++) {
      inIndex.put(inorder[i], i);
    }

    // Use a one-element array to carry the current preorder index through recursion
    int[] prePtr = {0};

    // Build the tree for the full inorder range
    return build(preorder, 0, inorder.length - 1, prePtr, inIndex);
  }

  // Recursive builder:
  // - preorder[prePtr[0]] is the next root
  // - split inorder at that root's index into left and right segments
  private TreeNode build(int[] preorder, int inL, int inR, int[] prePtr, Map<Integer, Integer> inIndex) {
    // Base case: empty inorder segment -> no node
    if (inL > inR) {
      return null;
    }

    // Take current root value from preorder and advance pointer
    int rootVal = preorder[prePtr[0]++];
    TreeNode root = new TreeNode(rootVal);

    // Position of root in inorder determines sizes of left/right subtrees
    int mid = inIndex.get(rootVal);

    // Build left subtree from inorder[inL .. mid-1]
    root.left = build(preorder, inL, mid - 1, prePtr, inIndex);

    // Build right subtree from inorder[mid+1 .. inR]
    root.right = build(preorder, mid + 1, inR, prePtr, inIndex);

    // Return the constructed subtree rooted at 'root'
    return root;
  }
}