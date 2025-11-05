package io.github.cristianmanoliu.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BinaryTreeRightSideViewTest {

  @Test
  void rightSideView() {
    BinaryTreeRightSideView solver = new BinaryTreeRightSideView();

    // Example 1
    TreeNode root1 = new TreeNode(1);
    root1.right = new TreeNode(3);
    root1.left = new TreeNode(2);
    root1.left.right = new TreeNode(5);
    root1.left.left = new TreeNode(4);
    assertEquals(
        java.util.Arrays.asList(1, 3, 5),
        solver.rightSideView(root1)
    );

    // Example 2
    TreeNode root2 = new TreeNode(1);
    root2.right = new TreeNode(3);
    assertEquals(
        java.util.Arrays.asList(1, 3),
        solver.rightSideView(root2)
    );

    // Example 3
    TreeNode root3 = null;
    assertEquals(
        java.util.Collections.emptyList(),
        solver.rightSideView(root3)
    );
  }
}