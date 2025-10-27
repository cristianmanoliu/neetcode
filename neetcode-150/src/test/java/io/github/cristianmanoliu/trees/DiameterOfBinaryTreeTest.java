package io.github.cristianmanoliu.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DiameterOfBinaryTreeTest {

  @Test
  public void testDiameterOfBinaryTree() {
    DiameterOfBinaryTree solution = new DiameterOfBinaryTree();

    // Test case 1: Example tree
    TreeNode root1 = new TreeNode(1);
    root1.left = new TreeNode(2);
    root1.right = new TreeNode(3);
    root1.left.left = new TreeNode(4);
    root1.left.right = new TreeNode(5);
    assertEquals(3, solution.diameterOfBinaryTree(root1));

    // Test case 2: Single node tree
    TreeNode root2 = new TreeNode(1);
    assertEquals(0, solution.diameterOfBinaryTree(root2));

    // Test case 3: Linear tree (skewed)
    TreeNode root3 = new TreeNode(1);
    root3.right = new TreeNode(2);
    root3.right.right = new TreeNode(3);
    assertEquals(2, solution.diameterOfBinaryTree(root3));

    // Test case 4: Empty tree
    assertEquals(0, solution.diameterOfBinaryTree(null));
  }
}