package io.github.cristianmanoliu.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class InvertBinaryTreeTest {

  @Test
  public void testInvertTree() {
    InvertBinaryTree invertBinaryTree = new InvertBinaryTree();

    TreeNode root = new TreeNode(4,
        new TreeNode(2,
            new TreeNode(1),
            new TreeNode(3)),
        new TreeNode(7,
            new TreeNode(6),
            new TreeNode(9))
    );

    TreeNode invertedRoot = invertBinaryTree.invertTree(root);

    assertEquals(4, invertedRoot.val);
    assertEquals(7, invertedRoot.left.val);
    assertEquals(2, invertedRoot.right.val);
    assertEquals(9, invertedRoot.left.left.val);
    assertEquals(6, invertedRoot.left.right.val);
    assertEquals(3, invertedRoot.right.left.val);
    assertEquals(1, invertedRoot.right.right.val);
  }

  @Test
  public void testInvertTreeSkewed() {
    InvertBinaryTree invertBinaryTree = new InvertBinaryTree();

    TreeNode root = new TreeNode(4,
        new TreeNode(1,
            new TreeNode(2,
                new TreeNode(3),
                null),
            null),
        null
    );

    TreeNode invertedRoot = invertBinaryTree.invertTree(root);

    assertEquals(4, invertedRoot.val);
    assertEquals(1, invertedRoot.right.val);
    assertEquals(2, invertedRoot.right.right.val);
    assertEquals(3, invertedRoot.right.right.right.val);

    // Verify all left children are null after inversion
    assertEquals(null, invertedRoot.left);
    assertEquals(null, invertedRoot.right.left);
    assertEquals(null, invertedRoot.right.right.left);
  }


}