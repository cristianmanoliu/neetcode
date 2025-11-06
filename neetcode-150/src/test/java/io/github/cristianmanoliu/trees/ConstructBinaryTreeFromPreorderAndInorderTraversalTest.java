package io.github.cristianmanoliu.trees;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// JUnit 5 tests for ConstructBinaryTreeFromPreorderAndInorderTraversal
class ConstructBinaryTreeFromPreorderAndInorderTraversalTest {

  // Helper: gather preorder traversal of a tree
  private int[] preorder(TreeNode root) {
    List<Integer> out = new ArrayList<>();
    preorderDfs(root, out);
    return out.stream().mapToInt(i -> i).toArray();
  }

  private void preorderDfs(TreeNode n, List<Integer> out) {
    if (n == null) {
      return;
    }
    out.add(n.val);
    preorderDfs(n.left, out);
    preorderDfs(n.right, out);
  }

  // Helper: gather inorder traversal of a tree
  private int[] inorder(TreeNode root) {
    List<Integer> out = new ArrayList<>();
    inorderDfs(root, out);
    return out.stream().mapToInt(i -> i).toArray();
  }

  private void inorderDfs(TreeNode n, List<Integer> out) {
    if (n == null) {
      return;
    }
    inorderDfs(n.left, out);
    out.add(n.val);
    inorderDfs(n.right, out);
  }

  @Test
  @DisplayName("LeetCode example: preorder [3,9,20,15,7], inorder [9,3,15,20,7]")
  void exampleFromLeetCode() {
    ConstructBinaryTreeFromPreorderAndInorderTraversal sol =
        new ConstructBinaryTreeFromPreorderAndInorderTraversal();

    int[] pre = {3, 9, 20, 15, 7};
    int[] in = {9, 3, 15, 20, 7};

    TreeNode root = sol.buildTree(pre, in);

    // Structure spot-check
    assertEquals(3, root.val);
    assertEquals(9, root.left.val);
    assertEquals(20, root.right.val);
    assertEquals(15, root.right.left.val);
    assertEquals(7, root.right.right.val);

    // Round-trip traversals should match inputs
    assertArrayEquals(pre, preorder(root));
    assertArrayEquals(in, inorder(root));
  }

  @Test
  @DisplayName("Single node")
  void singleNode() {
    ConstructBinaryTreeFromPreorderAndInorderTraversal sol =
        new ConstructBinaryTreeFromPreorderAndInorderTraversal();

    int[] pre = {1};
    int[] in = {1};

    TreeNode root = sol.buildTree(pre, in);
    assertEquals(1, root.val);
    assertArrayEquals(pre, preorder(root));
    assertArrayEquals(in, inorder(root));
  }

  @Test
  @DisplayName("Empty arrays -> null tree")
  void emptyInput() {
    ConstructBinaryTreeFromPreorderAndInorderTraversal sol =
        new ConstructBinaryTreeFromPreorderAndInorderTraversal();

    int[] pre = {};
    int[] in = {};
    TreeNode root = sol.buildTree(pre, in);
    // Preorder/Inorder of null is empty
    assertArrayEquals(new int[0], preorder(root));
    assertArrayEquals(new int[0], inorder(root));
  }

  @Test
  @DisplayName("Skewed left tree")
  void skewedLeft() {
    ConstructBinaryTreeFromPreorderAndInorderTraversal sol =
        new ConstructBinaryTreeFromPreorderAndInorderTraversal();

    // Tree: 3 -> 2 -> 1 (all left)
    int[] pre = {3, 2, 1};
    int[] in = {1, 2, 3};

    TreeNode root = sol.buildTree(pre, in);
    assertArrayEquals(pre, preorder(root));
    assertArrayEquals(in, inorder(root));
  }

  @Test
  @DisplayName("Skewed right tree")
  void skewedRight() {
    ConstructBinaryTreeFromPreorderAndInorderTraversal sol =
        new ConstructBinaryTreeFromPreorderAndInorderTraversal();

    // Tree: 1 -> 2 -> 3 (all right)
    int[] pre = {1, 2, 3};
    int[] in = {1, 2, 3};

    TreeNode root = sol.buildTree(pre, in);
    assertArrayEquals(pre, preorder(root));
    assertArrayEquals(in, inorder(root));
  }
}