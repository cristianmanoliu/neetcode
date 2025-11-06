package io.github.cristianmanoliu.trees;

// https://neetcode.io/problems/serialize-and-deserialize-binary-tree?list=neetcode150
// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
public class SerializeAndDeserializeBinaryTree {

  // Encodes a tree to a single string using DFS preorder traversal.
  // We write each node's value, and for nulls we write "N".
  // Example:    1
  //            / \
  //           2   3
  //              / \
  //             4   5
  // becomes: "1,2,N,N,3,4,N,N,5,N,N"
  public String serialize(TreeNode root) {
    // Use StringBuilder for efficient concatenation
    StringBuilder sb = new StringBuilder();
    serializeDfs(root, sb);
    return sb.toString();
  }

  private void serializeDfs(TreeNode node, StringBuilder sb) {
    // Base case: use sentinel "N" for null pointers
    if (node == null) {
      sb.append("N").append(",");
      return;
    }
    // Write current node value
    sb.append(node.val).append(",");
    // Recurse left then right (preorder)
    serializeDfs(node.left, sb);
    serializeDfs(node.right, sb);
  }

  // Decodes your encoded data to tree.
  // We read the tokens in the same preorder sequence.
  // When we see "N" we return null; otherwise we create a node and build its subtrees.
  public TreeNode deserialize(String data) {
    // Handle empty input
    if (data == null || data.isEmpty()) {
      return null;
    }
    // Split by commas into a token array; trailing comma is fine
    String[] tokens = data.split(",");
    // Use a single-element array as a mutable index across recursive calls
    int[] idx = {0};
    return deserializeDfs(tokens, idx);
  }

  private TreeNode deserializeDfs(String[] tokens, int[] idx) {
    // Base case: if current token is "N", it's a null pointer
    if (tokens[idx[0]].equals("N")) {
      idx[0]++; // move past "N"
      return null;
    }

    // Parse the current value and create the node
    int val = Integer.parseInt(tokens[idx[0]++]);
    TreeNode node = new TreeNode(val);

    // Reconstruct left and right subtrees in preorder
    node.left = deserializeDfs(tokens, idx);
    node.right = deserializeDfs(tokens, idx);
    return node;
  }
}
