package io.github.cristianmanoliu.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class KthSmallestIntegerInBSTTest {

  @Test
  void kthSmallest() {
    KthSmallestIntegerInBST solution = new KthSmallestIntegerInBST();

    // Test case 1
    TreeNode root1 = new TreeNode(3);
    root1.left = new TreeNode(1);
    root1.right = new TreeNode(4);
    root1.left.right = new TreeNode(2);
    int k1 = 1;
    assertEquals(1, solution.kthSmallest(root1, k1));

    // Test case 2
    TreeNode root2 = new TreeNode(5);
    root2.left = new TreeNode(3);
    root2.right = new TreeNode(6);
    root2.left.left = new TreeNode(2);
    root2.left.right = new TreeNode(4);
    root2.left.left.left = new TreeNode(1);
    int k2 = 3;
    assertEquals(3, solution.kthSmallest(root2, k2));

    // Test case 3: Single node tree
    TreeNode root3 = new TreeNode(10);
    int k3 = 1;
    assertEquals(10, solution.kthSmallest(root3, k3));

    // Test case 4: Larger tree
    TreeNode root4 = new TreeNode(8);
    root4.left = new TreeNode(3);
    root4.right = new TreeNode(10);
    root4.left.left = new TreeNode(1);
    root4.left.right = new TreeNode(6);
    root4.left.right.left = new TreeNode(4);
    root4.left.right.right = new TreeNode(7);
    root4.right.right = new TreeNode(14);
    root4.right.right.left = new TreeNode(13);
    int k4 = 5;
    assertEquals(7, solution.kthSmallest(root4, k4));
  }
}