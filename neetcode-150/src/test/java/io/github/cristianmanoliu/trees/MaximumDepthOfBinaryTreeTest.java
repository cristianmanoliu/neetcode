package io.github.cristianmanoliu.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MaximumDepthOfBinaryTreeTest {

  @Test
  public void testMaxDepth() {
    MaximumDepthOfBinaryTree maxDepthCalculator = new MaximumDepthOfBinaryTree();

    TreeNode root = new TreeNode(3,
        new TreeNode(9),
        new TreeNode(20,
            new TreeNode(15),
            new TreeNode(7))
    );

    int depth = maxDepthCalculator.maxDepth(root);
    assertEquals(3, depth);
  }

}