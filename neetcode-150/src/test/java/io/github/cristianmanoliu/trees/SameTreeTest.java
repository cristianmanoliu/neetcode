package io.github.cristianmanoliu.trees;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SameTreeTest {

  @Test
  public void testIsSameTree() {
    SameTree solution = new SameTree();

    // Test case 1: Identical trees
    TreeNode p1 = new TreeNode(1);
    p1.left = new TreeNode(2);
    p1.right = new TreeNode(3);

    TreeNode q1 = new TreeNode(1);
    q1.left = new TreeNode(2);
    q1.right = new TreeNode(3);

    assertTrue(solution.isSameTree(p1, q1));

    // Test case 2: Different structure
    TreeNode p2 = new TreeNode(1);
    p2.left = new TreeNode(2);

    TreeNode q2 = new TreeNode(1);
    q2.right = new TreeNode(2);

    assertFalse(solution.isSameTree(p2, q2));

    // Test case 3: Different values
    TreeNode p3 = new TreeNode(1);
    p3.left = new TreeNode(2);
    p3.right = new TreeNode(1);

    TreeNode q3 = new TreeNode(1);
    q3.left = new TreeNode(1);
    q3.right = new TreeNode(2);

    assertFalse(solution.isSameTree(p3, q3));

    // Test case 4: Both trees are null
    assertTrue(solution.isSameTree(null, null));

    // Test case 5: One tree is null
    TreeNode p5 = new TreeNode(1);
    assertFalse(solution.isSameTree(p5, null));
  }

}