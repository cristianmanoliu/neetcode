package io.github.cristianmanoliu.trees;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BalancedBinaryTreeTest {

  @Test
  public void testIsBalanced() {
    BalancedBinaryTree solution = new BalancedBinaryTree();

    // Test case 1: Balanced tree
    TreeNode root1 = new TreeNode(3);
    root1.left = new TreeNode(9);
    root1.right = new TreeNode(20);
    root1.right.left = new TreeNode(15);
    root1.right.right = new TreeNode(7);
    assertTrue(solution.isBalanced(root1));

    // Test case 2: Unbalanced tree
    TreeNode root2 = new TreeNode(1);
    root2.left = new TreeNode(2);
    root2.right = new TreeNode(2);
    root2.left.left = new TreeNode(3);
    root2.left.right = new TreeNode(3);
    root2.left.left.left = new TreeNode(4);
    root2.left.left.right = new TreeNode(4);
    assertFalse(solution.isBalanced(root2));

    // Test case 3: Single node tree
    TreeNode root3 = new TreeNode(1);
    assertTrue(solution.isBalanced(root3));

    // Test case 4: Empty tree
    assertTrue(solution.isBalanced(null));
  }

}