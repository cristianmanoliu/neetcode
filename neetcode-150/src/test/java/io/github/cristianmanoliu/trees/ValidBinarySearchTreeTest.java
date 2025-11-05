package io.github.cristianmanoliu.trees;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ValidBinarySearchTreeTest {

  @Test
  void isValidBST() {
    ValidBinarySearchTree solution = new ValidBinarySearchTree();

    // Test case 1: Valid BST
    TreeNode root1 = new TreeNode(2);
    root1.left = new TreeNode(1);
    root1.right = new TreeNode(3);
    assertTrue(solution.isValidBST(root1));

    // Test case 2: Invalid BST
    TreeNode root2 = new TreeNode(5);
    root2.left = new TreeNode(1);
    root2.right = new TreeNode(4);
    root2.right.left = new TreeNode(3);
    root2.right.right = new TreeNode(6);
    assertFalse(solution.isValidBST(root2));

    // Test case 3: Single node tree (valid BST)
    TreeNode root3 = new TreeNode(10);
    assertTrue(solution.isValidBST(root3));

    // Test case 4: Empty tree (valid BST)
    assertTrue(solution.isValidBST(null));

    // Test case 5: Larger valid BST
    TreeNode root4 = new TreeNode(10);
    root4.left = new TreeNode(5);
    root4.right = new TreeNode(15);
    root4.right.left = new TreeNode(12);
    root4.right.right = new TreeNode(20);
    assertTrue(solution.isValidBST(root4));

    // Test case 6: Invalid BST with duplicate values
    TreeNode root5 = new TreeNode(10);
    root5.left = new TreeNode(10);
    root5.right = new TreeNode(15);
    assertFalse(solution.isValidBST(root5));
  }
}