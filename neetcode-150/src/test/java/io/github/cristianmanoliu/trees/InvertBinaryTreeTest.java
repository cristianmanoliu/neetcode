package io.github.cristianmanoliu.trees;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// JUnit 5 tests for InvertBinaryTree
class InvertBinaryTreeTest {

  // Helper: quick node constructor with children
  private TreeNode n(int v, TreeNode l, TreeNode r) {
    TreeNode t = new TreeNode(v);
    t.left = l;
    t.right = r;
    return t;
  }

  // Deep structural equality check for binary trees
  private boolean eq(TreeNode a, TreeNode b) {
    if (a == null || b == null) {
      return a == b;
    }
    return a.val == b.val && eq(a.left, b.left) && eq(a.right, b.right);
  }

  @Test
  @DisplayName("Empty tree -> null")
  void emptyTree() {
    InvertBinaryTree sol = new InvertBinaryTree();
    assertNull(sol.invertTree(null));
  }

  @Test
  @DisplayName("Single node remains the same after invert")
  void singleNode() {
    InvertBinaryTree sol = new InvertBinaryTree();
    TreeNode root = new TreeNode(7);
    TreeNode res = sol.invertTree(root);
    assertTrue(eq(res, new TreeNode(7)));
  }

  @Test
  @DisplayName("LeetCode example: [4,2,7,1,3,6,9] -> [4,7,2,9,6,3,1]")
  void exampleFromProblem() {
    InvertBinaryTree sol = new InvertBinaryTree();

    // Original:
    //        4
    //       / \
    //      2   7
    //     / \ / \
    //    1  3 6  9
    TreeNode root =
        n(4,
            n(2, new TreeNode(1), new TreeNode(3)),
            n(7, new TreeNode(6), new TreeNode(9)));

    // Expected inverted:
    //        4
    //       / \
    //      7   2
    //     / \ / \
    //    9  6 3  1
    TreeNode expected =
        n(4,
            n(7, new TreeNode(9), new TreeNode(6)),
            n(2, new TreeNode(3), new TreeNode(1)));

    TreeNode res = sol.invertTree(root);
    assertTrue(eq(res, expected));
  }

  @Test
  @DisplayName("Left-skewed becomes right-skewed after invert")
  void leftToRightSkew() {
    InvertBinaryTree sol = new InvertBinaryTree();
    //   3
    //  /
    // 2
    // /
    //1
    TreeNode root = n(3, n(2, new TreeNode(1), null), null);

    // After invert:
    // 3
    //  \
    //   2
    //    \
    //     1
    TreeNode expected = n(3, null, n(2, null, new TreeNode(1)));

    assertTrue(eq(sol.invertTree(root), expected));
  }

  @Test
  @DisplayName("Double invert yields the original tree structure")
  void doubleInvertIsIdentity() {
    InvertBinaryTree sol = new InvertBinaryTree();

    // Build two identical trees: one to keep as original, one to mutate
    TreeNode original =
        n(8,
            n(3, new TreeNode(1), n(6, new TreeNode(4), new TreeNode(7))),
            n(10, null, n(14, new TreeNode(13), null)));

    TreeNode t =
        n(8,
            n(3, new TreeNode(1), n(6, new TreeNode(4), new TreeNode(7))),
            n(10, null, n(14, new TreeNode(13), null)));

    // Invert twice
    t = sol.invertTree(t);
    t = sol.invertTree(t);

    // Should be structurally equal to the untouched original
    assertTrue(eq(t, original));
  }
}