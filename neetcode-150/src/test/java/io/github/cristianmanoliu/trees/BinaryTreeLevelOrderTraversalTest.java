package io.github.cristianmanoliu.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class BinaryTreeLevelOrderTraversalTest {

  @Test
  public void levelOrder() {
    BinaryTreeLevelOrderTraversal solution = new BinaryTreeLevelOrderTraversal();
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);

    var result = solution.levelOrder(root);
    var expected = List.of(
        List.of(3),
        List.of(9, 20),
        List.of(15, 7)
    );

    assertEquals(expected, result);
  }
}