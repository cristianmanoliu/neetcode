package io.github.cristianmanoliu.trees;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// JUnit 5 tests for SubtreeOfAnotherTree
class SubtreeOfAnotherTreeTest {

  // Helper: quick node constructor with children
  private TreeNode n(int v, TreeNode l, TreeNode r) {
    TreeNode t = new TreeNode(v);
    t.left = l;
    t.right = r;
    return t;
  }

  @Test
  @DisplayName("Empty subRoot is always a subtree")
  void emptySubRoot() {
    SubtreeOfAnotherTree sol = new SubtreeOfAnotherTree();
    TreeNode root = new TreeNode(1);
    assertTrue(sol.isSubtree(root, null));
  }

  @Test
  @DisplayName("Non-empty subRoot cannot be a subtree of an empty root")
  void subRootButEmptyRoot() {
    SubtreeOfAnotherTree sol = new SubtreeOfAnotherTree();
    assertFalse(sol.isSubtree(null, new TreeNode(1)));
  }

  @Test
  @DisplayName("Classic positive example: subRoot exists in root")
  void classicPositive() {
    SubtreeOfAnotherTree sol = new SubtreeOfAnotherTree();
    // root:       3
    //            / \
    //           4   5
    //          / \
    //         1   2
    TreeNode root = n(3, n(4, new TreeNode(1), new TreeNode(2)), new TreeNode(5));
    // subRoot:   4
    //           / \
    //          1   2
    TreeNode subRoot = n(4, new TreeNode(1), new TreeNode(2));
    assertTrue(sol.isSubtree(root, subRoot));
  }

  @Test
  @DisplayName("Tricky negative: extra node in root prevents a match")
  void trickyNegativeExtraNode() {
    SubtreeOfAnotherTree sol = new SubtreeOfAnotherTree();
    // root:       3
    //            / \
    //           4   5
    //          / \
    //         1   2
    //            /
    //           0
    TreeNode root = n(3,
        n(4, new TreeNode(1), n(2, new TreeNode(0), null)),
        new TreeNode(5));

    // subRoot:   4
    //           / \
    //          1   2
    TreeNode subRoot = n(4, new TreeNode(1), new TreeNode(2));

    assertFalse(sol.isSubtree(root, subRoot));
  }

  @Test
  @DisplayName("Identical trees -> true")
  void identicalTrees() {
    SubtreeOfAnotherTree sol = new SubtreeOfAnotherTree();
    TreeNode a = n(2, new TreeNode(1), new TreeNode(3));
    TreeNode b = n(2, new TreeNode(1), new TreeNode(3));
    assertTrue(sol.isSubtree(a, b));
  }

  @Test
  @DisplayName("Values present but structure differs -> false")
  void sameValuesDifferentStructure() {
    SubtreeOfAnotherTree sol = new SubtreeOfAnotherTree();
    // root:    1
    //         / \
    //        1   1
    TreeNode root = n(1, new TreeNode(1), new TreeNode(1));
    // subRoot: 1
    //           \
    //            1
    TreeNode subRoot = n(1, null, new TreeNode(1));
    assertFalse(sol.isSubtree(root, subRoot));
  }

  @Test
  @DisplayName("Repeated values require exact structure to match")
  void repeatedValuesStructureMatters() {
    SubtreeOfAnotherTree sol = new SubtreeOfAnotherTree();
    // root:       1
    //            /
    //           1
    //          /
    //         1
    TreeNode root = n(1, n(1, new TreeNode(1), null), null);
    // subRoot:   1
    //             \
    //              1
    TreeNode subRoot = n(1, null, new TreeNode(1));
    assertFalse(sol.isSubtree(root, subRoot));
  }
}
