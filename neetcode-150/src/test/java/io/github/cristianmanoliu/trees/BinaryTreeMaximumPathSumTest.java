package io.github.cristianmanoliu.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BinaryTreeMaximumPathSumTest {

  @Test
  void maxPathSum() {
    BinaryTreeMaximumPathSum solution = new BinaryTreeMaximumPathSum();

    // Test case 1
    TreeNode root1 = new TreeNode(1);
    root1.left = new TreeNode(2);
    root1.right = new TreeNode(3);
    assertEquals(6, solution.maxPathSum(root1));

    // Test case 2
    TreeNode root2 = new TreeNode(-10);
    root2.left = new TreeNode(9);
    root2.right = new TreeNode(20);
    root2.right.left = new TreeNode(15);
    root2.right.right = new TreeNode(7);
    assertEquals(42, solution.maxPathSum(root2));

    // Test case 3: Single node tree
    TreeNode root3 = new TreeNode(-3);
    assertEquals(-3, solution.maxPathSum(root3));

    // Test case 4: All negative values
    TreeNode root4 = new TreeNode(-2);
    root4.left = new TreeNode(-1);
    root4.right = new TreeNode(-3);
    assertEquals(-1, solution.maxPathSum(root4));
  }
}