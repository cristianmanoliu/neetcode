package io.github.cristianmanoliu.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// JUnit 5 tests for LowestCommonAncestorInBinarySearchTree
class LowestCommonAncestorInBinarySearchTreeTest {

  // Helper: quick node constructor with children
  private TreeNode n(int v, TreeNode l, TreeNode r) {
    TreeNode t = new TreeNode(v);
    t.left = l;
    t.right = r;
    return t;
  }

  @Test
  @DisplayName("Classic BST: split at root -> LCA is root")
  void splitAtRoot() {
    LowestCommonAncestorInBinarySearchTree sol = new LowestCommonAncestorInBinarySearchTree();
    //        6
    //       / \
    //      2   8
    //     / \ / \
    //    0  4 7  9
    //      / \
    //     3   5
    TreeNode n3 = new TreeNode(3);
    TreeNode n5 = new TreeNode(5);
    TreeNode n4 = n(4, n3, n5);
    TreeNode n2 = n(2, new TreeNode(0), n4);
    TreeNode n8 = n(8, new TreeNode(7), new TreeNode(9));
    TreeNode root = n(6, n2, n8);

    // p=2, q=8 -> LCA is 6 (root)
    assertEquals(root, sol.lowestCommonAncestor(root, n2, n8));
  }

  @Test
  @DisplayName("Ancestor case: one node is ancestor of the other")
  void oneIsAncestor() {
    LowestCommonAncestorInBinarySearchTree sol = new LowestCommonAncestorInBinarySearchTree();
    // Reuse the classic tree
    TreeNode n3 = new TreeNode(3);
    TreeNode n5 = new TreeNode(5);
    TreeNode n4 = n(4, n3, n5);
    TreeNode n2 = n(2, new TreeNode(0), n4);
    TreeNode n8 = n(8, new TreeNode(7), new TreeNode(9));
    TreeNode root = n(6, n2, n8);

    // p=2, q=4 -> LCA is 2 (ancestor)
    assertEquals(n2, sol.lowestCommonAncestor(root, n2, n4));
  }

  @Test
  @DisplayName("Deep inside same subtree")
  void insideSameSubtree() {
    LowestCommonAncestorInBinarySearchTree sol = new LowestCommonAncestorInBinarySearchTree();
    TreeNode n3 = new TreeNode(3);
    TreeNode n5 = new TreeNode(5);
    TreeNode n4 = n(4, n3, n5);
    TreeNode n2 = n(2, new TreeNode(0), n4);
    TreeNode n8 = n(8, new TreeNode(7), new TreeNode(9));
    TreeNode root = n(6, n2, n8);

    // p=3, q=5 -> LCA is 4
    assertEquals(n4, sol.lowestCommonAncestor(root, n3, n5));
  }

  @Test
  @DisplayName("Order of p and q does not matter")
  void orderDoesNotMatter() {
    LowestCommonAncestorInBinarySearchTree sol = new LowestCommonAncestorInBinarySearchTree();
    TreeNode n3 = new TreeNode(3);
    TreeNode n5 = new TreeNode(5);
    TreeNode n4 = n(4, n3, n5);
    TreeNode n2 = n(2, new TreeNode(0), n4);
    TreeNode n8 = n(8, new TreeNode(7), new TreeNode(9));
    TreeNode root = n(6, n2, n8);

    // p=8, q=2 -> LCA is 6 (root)
    assertEquals(root, sol.lowestCommonAncestor(root, n8, n2));
  }

  @Test
  @DisplayName("Skewed right BST")
  void skewedRight() {
    LowestCommonAncestorInBinarySearchTree sol = new LowestCommonAncestorInBinarySearchTree();
    // 1 -> 2 -> 3 (all to the right)
    TreeNode n3 = new TreeNode(3);
    TreeNode n2 = n(2, null, n3);
    TreeNode root = n(1, null, n2);

    // p=2, q=3 -> LCA is 2
    assertEquals(n2, sol.lowestCommonAncestor(root, n2, n3));
  }
}
