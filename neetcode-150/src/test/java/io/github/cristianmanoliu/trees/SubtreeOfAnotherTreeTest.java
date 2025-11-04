package io.github.cristianmanoliu.trees;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SubtreeOfAnotherTreeTest {

  @Test
  public void testIsSubtree() {
    SubtreeOfAnotherTree solution = new SubtreeOfAnotherTree();

    TreeNode s1 = new TreeNode(3,
        new TreeNode(4,
            new TreeNode(1),
            new TreeNode(2,
                new TreeNode(0),
                null)),
        new TreeNode(5));
    TreeNode t1 = new TreeNode(4,
        new TreeNode(1),
        new TreeNode(2));
    assertFalse(solution.isSubtree(s1, t1));

    TreeNode s2 = new TreeNode(3,
        new TreeNode(4,
            new TreeNode(1),
            new TreeNode(2)),
        new TreeNode(5));
    TreeNode t2 = new TreeNode(4,
        new TreeNode(1),
        new TreeNode(2));
    assertTrue(solution.isSubtree(s2, t2));

    TreeNode s3 = new TreeNode(1,
        new TreeNode(1),
        null);
    TreeNode t3 = new TreeNode(1);
    assertTrue(solution.isSubtree(s3, t3));
  }

}