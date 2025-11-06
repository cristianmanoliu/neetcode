package io.github.cristianmanoliu.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// JUnit 5 tests for BinaryTreeRightSideView
class BinaryTreeRightSideViewTest {

  // Helper: quick node constructor with children
  private TreeNode n(int v, TreeNode l, TreeNode r) {
    TreeNode t = new TreeNode(v);
    t.left = l;
    t.right = r;
    return t;
  }

  @Test
  @DisplayName("Empty tree -> empty right view")
  void emptyTree() {
    BinaryTreeRightSideView sol = new BinaryTreeRightSideView();
    assertEquals(List.of(), sol.rightSideView(null));
  }

  @Test
  @DisplayName("Single node tree -> [value]")
  void singleNode() {
    BinaryTreeRightSideView sol = new BinaryTreeRightSideView();
    TreeNode root = new TreeNode(7);
    assertEquals(List.of(7), sol.rightSideView(root));
  }

  @Test
  @DisplayName("Classic example: [1,2,3,null,5,null,4] -> [1,3,4]")
  void classicExample() {
    BinaryTreeRightSideView sol = new BinaryTreeRightSideView();
    //      1
    //     / \
    //    2   3
    //     \   \
    //      5   4
    TreeNode root = n(1,
        n(2, null, new TreeNode(5)),
        n(3, null, new TreeNode(4)));
    assertEquals(List.of(1, 3, 4), sol.rightSideView(root));
  }

  @Test
  @DisplayName("Left-skewed chain -> all nodes visible")
  void leftSkewed() {
    BinaryTreeRightSideView sol = new BinaryTreeRightSideView();
    //   1
    //  /
    // 2
    // /
    //3
    TreeNode root = n(1, n(2, new TreeNode(3), null), null);
    assertEquals(List.of(1, 2, 3), sol.rightSideView(root));
  }

  @Test
  @DisplayName("Right-skewed chain -> all nodes visible")
  void rightSkewed() {
    BinaryTreeRightSideView sol = new BinaryTreeRightSideView();
    // 1
    //  \
    //   2
    //    \
    //     3
    TreeNode root = n(1, null, n(2, null, new TreeNode(3)));
    assertEquals(List.of(1, 2, 3), sol.rightSideView(root));
  }

  @Test
  @DisplayName("Mixed levels where right child is missing at some depths")
  void mixedMissingRights() {
    BinaryTreeRightSideView sol = new BinaryTreeRightSideView();
    //        8
    //       / \
    //      3   10
    //     / \    \
    //    1   6    14
    //       / \   /
    //      4   7 13
    TreeNode root = n(8,
        n(3,
            new TreeNode(1),
            n(6, new TreeNode(4), new TreeNode(7))),
        n(10,
            null,
            n(14, new TreeNode(13), null)));
    // Levels: 8 | 3,10 | 1,6,14 | 4,7,13
    // Right view: 8,10,14,13
    assertEquals(List.of(8, 10, 14, 13), sol.rightSideView(root));
  }
}
