package io.github.cristianmanoliu.trees;

import java.util.HashMap;
import java.util.Map;

// https://neetcode.io/problems/binary-tree-from-preorder-and-inorder-traversal?list=neetcode150
// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    // Edge cases
    if (preorder == null || inorder == null || preorder.length != inorder.length || preorder.length == 0) {
      return null;
    }
    // Build a map to store the index of each value in inorder traversal for quick lookup
    Map<Integer, Integer> inIndex = new HashMap<>(inorder.length * 2);
    // Populate the map
    for (int i = 0; i < inorder.length; i++) {
      inIndex.put(inorder[i], i);
    }
    // Use an array to keep track of the current index in preorder traversal
    int[] prePtr = {0};
    // Start building the tree
    return build(preorder, 0, inorder.length - 1, prePtr, inIndex);
  }

  private TreeNode build(int[] preorder, int inL, int inR, int[] prePtr, Map<Integer, Integer> inIndex) {
    // Base case: if the current inorder segment is invalid
    if (inL > inR) {
      return null;
    }
    // Get the root value from preorder traversal
    int rootVal = preorder[prePtr[0]++];
    // Create the root node
    TreeNode root = new TreeNode(rootVal);

    // Find the index of the root value in inorder traversal
    int mid = inIndex.get(rootVal);
    // Recursively build the left and right subtrees
    // Left subtree: inorder[inL...mid-1]
    root.left = build(preorder, inL, mid - 1, prePtr, inIndex);
    // Right subtree: inorder[mid+1...inR]
    root.right = build(preorder, mid + 1, inR, prePtr, inIndex);
    // Return the constructed subtree rooted at 'root'
    return root;
  }
}
