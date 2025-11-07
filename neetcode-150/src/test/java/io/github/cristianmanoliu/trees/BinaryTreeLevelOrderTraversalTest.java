package io.github.cristianmanoliu.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BinaryTreeLevelOrderTraversalTest {

  // Helper: quick constructor with children
  private TreeNode n(int v, TreeNode l, TreeNode r) {
    TreeNode t = new TreeNode(v);
    t.left = l;
    t.right = r;
    return t;
  }

  @Test
  @DisplayName("Empty tree -> empty levels")
  void emptyTree() {
    BinaryTreeLevelOrderTraversal sol = new BinaryTreeLevelOrderTraversal();
    assertEquals(List.of(), sol.levelOrder(null));
  }

  @Test
  @DisplayName("Single node -> one level with the node value")
  void singleNode() {
    BinaryTreeLevelOrderTraversal sol = new BinaryTreeLevelOrderTraversal();
    TreeNode root = new TreeNode(1);
    assertEquals(List.of(List.of(1)), sol.levelOrder(root));
  }

  @Test
  @DisplayName("Balanced example: [3,9,20,null,null,15,7] -> [[3],[9,20],[15,7]]")
  void balancedExample() {
    BinaryTreeLevelOrderTraversal sol = new BinaryTreeLevelOrderTraversal();
    //      3
    //     / \
    //    9  20
    //       / \
    //      15  7
    TreeNode root = n(3, new TreeNode(9), n(20, new TreeNode(15), new TreeNode(7)));
    assertEquals(List.of(List.of(3), List.of(9, 20), List.of(15, 7)), sol.levelOrder(root));
  }

  @Test
  @DisplayName("Left-skewed chain -> each level has one node")
  void leftSkewed() {
    BinaryTreeLevelOrderTraversal sol = new BinaryTreeLevelOrderTraversal();
    //   1
    //  /
    // 2
    // /
    //3
    TreeNode root = n(1, n(2, new TreeNode(3), null), null);
    assertEquals(List.of(List.of(1), List.of(2), List.of(3)), sol.levelOrder(root));
  }

  @Test
  @DisplayName("Right-skewed chain -> each level has one node")
  void rightSkewed() {
    BinaryTreeLevelOrderTraversal sol = new BinaryTreeLevelOrderTraversal();
    // 1
    //  \
    //   2
    //    \
    //     3
    TreeNode root = n(1, null, n(2, null, new TreeNode(3)));
    assertEquals(List.of(List.of(1), List.of(2), List.of(3)), sol.levelOrder(root));
  }

  @Test
  @DisplayName("Mixed tree with missing children at some levels")
  void mixedTree() {
    BinaryTreeLevelOrderTraversal sol = new BinaryTreeLevelOrderTraversal();
    //        8
    //       / \
    //      3   10
    //     / \    \
    //    1   6    14
    //       / \   /
    //      4   7 13
    TreeNode root = n(8,
        n(3, new TreeNode(1), n(6, new TreeNode(4), new TreeNode(7))),
        n(10, null, n(14, new TreeNode(13), null)));
    assertEquals(
        List.of(List.of(8), List.of(3, 10), List.of(1, 6, 14), List.of(4, 7, 13)),
        sol.levelOrder(root));
  }
}
