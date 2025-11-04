package io.github.cristianmanoliu.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LowestCommonAncestorInBinarySearchTreeTest {

  @Test
  void lowestCommonAncestor() {
    LowestCommonAncestorInBinarySearchTree solver = new LowestCommonAncestorInBinarySearchTree();

    // Example 1
    TreeNode root1 = new TreeNode(6);
    root1.left = new TreeNode(2);
    root1.right = new TreeNode(8);
    root1.left.left = new TreeNode(0);
    root1.left.right = new TreeNode(4);
    root1.left.right.left = new TreeNode(3);
    root1.left.right.right = new TreeNode(5);
    root1.right.left = new TreeNode(7);
    root1.right.right = new TreeNode(9);
    TreeNode p1 = root1.left; // 2
    TreeNode q1 = root1.right; // 8
    TreeNode expected1 = root1; // 6
    assertEquals(expected1, solver.lowestCommonAncestor(root1, p1, q1));

    // Example 2
    TreeNode root2 = new TreeNode(6);
    root2.left = new TreeNode(2);
    root2.right = new TreeNode(8);
    root2.left.left = new TreeNode(0);
    root2.left.right = new TreeNode(4);
    root2.left.right.left = new TreeNode(3);
    root2.left.right.right = new TreeNode(5);
    root2.right.left = new TreeNode(7);
    root2.right.right = new TreeNode(9);
    TreeNode p2 = root2.left; // 2
    TreeNode q2 = root2.left.right; // 4
    TreeNode expected2 = root2.left; // 2
    assertEquals(expected2, solver.lowestCommonAncestor(root2, p2, q2));

  }
}