package io.github.cristianmanoliu.trees;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SameTreeTest {

  // Helper: quick node constructor with children
  private TreeNode n(int v, TreeNode l, TreeNode r) {
    TreeNode t = new TreeNode(v);
    t.left = l;
    t.right = r;
    return t;
  }

  @Test
  @DisplayName("Both trees null -> true")
  void bothNull() {
    SameTree sol = new SameTree();
    assertTrue(sol.isSameTree(null, null));
  }

  @Test
  @DisplayName("One null, one non-null -> false")
  void oneNull() {
    SameTree sol = new SameTree();
    assertFalse(sol.isSameTree(new TreeNode(1), null));
    assertFalse(sol.isSameTree(null, new TreeNode(1)));
  }

  @Test
  @DisplayName("Identical single-node trees -> true")
  void singleNodeSame() {
    SameTree sol = new SameTree();
    assertTrue(sol.isSameTree(new TreeNode(7), new TreeNode(7)));
  }

  @Test
  @DisplayName("Single-node with different values -> false")
  void singleNodeDifferentValue() {
    SameTree sol = new SameTree();
    assertFalse(sol.isSameTree(new TreeNode(7), new TreeNode(8)));
  }

  @Test
  @DisplayName("Same structure & values -> true")
  void sameStructureSameValues() {
    SameTree sol = new SameTree();
    //      2
    //     / \
    //    1   3
    TreeNode a = n(2, new TreeNode(1), new TreeNode(3));
    TreeNode b = n(2, new TreeNode(1), new TreeNode(3));
    assertTrue(sol.isSameTree(a, b));
  }

  @Test
  @DisplayName("Different structure -> false")
  void differentStructure() {
    SameTree sol = new SameTree();
    // a:    1         b:   1
    //      / \             /
    //     2   3           2
    //                      \
    //                       3
    TreeNode a = n(1, new TreeNode(2), new TreeNode(3));
    TreeNode b = n(1, new TreeNode(2), null);
    b.left.right = new TreeNode(3);
    assertFalse(sol.isSameTree(a, b));
  }

  @Test
  @DisplayName("Larger trees equal vs. with one differing value")
  void largerTrees() {
    SameTree sol = new SameTree();
    //         8
    //        / \
    //       3   10
    //      / \    \
    //     1   6    14
    //        / \   /
    //       4   7 13
    TreeNode a = n(8,
        n(3, new TreeNode(1), n(6, new TreeNode(4), new TreeNode(7))),
        n(10, null, n(14, new TreeNode(13), null)));
    TreeNode b = n(8,
        n(3, new TreeNode(1), n(6, new TreeNode(4), new TreeNode(7))),
        n(10, null, n(14, new TreeNode(13), null)));

    // Equal trees -> true
    assertTrue(sol.isSameTree(a, b));

    // Change one value and expect false
    b.right.right.left.val = 12; // mutate b at value 13 -> 12
    assertFalse(sol.isSameTree(a, b));
  }
}