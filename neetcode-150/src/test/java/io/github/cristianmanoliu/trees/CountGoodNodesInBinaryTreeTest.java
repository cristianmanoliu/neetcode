package io.github.cristianmanoliu.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CountGoodNodesInBinaryTreeTest {

  @Test
  void goodNodes() {
    CountGoodNodesInBinaryTree solver = new CountGoodNodesInBinaryTree();

    // Example 1
    TreeNode root1 = new TreeNode(3);
    root1.left = new TreeNode(1);
    root1.right = new TreeNode(4);
    root1.left.left = new TreeNode(3);
    root1.right.right = new TreeNode(5);
    assertEquals(4, solver.goodNodes(root1));

    // Example 2
    TreeNode root2 = new TreeNode(3);
    root2.left = new TreeNode(3);
    root2.right = new TreeNode(4);
    root2.left.left = new TreeNode(4);
    root2.right.right = new TreeNode(5);
    assertEquals(5, solver.goodNodes(root2));

    // Example 3
    TreeNode root3 = new TreeNode(1);
    assertEquals(1, solver.goodNodes(root3));
  }
}