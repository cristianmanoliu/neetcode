package io.github.cristianmanoliu.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// JUnit 5 tests for SerializeAndDeserializeBinaryTree
class SerializeAndDeserializeBinaryTreeTest {

  // Helper: create a small balanced tree for round-trip tests
  //      1
  //     / \
  //    2   3
  //       / \
  //      4   5
  private TreeNode sampleBalanced() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.right.left = new TreeNode(4);
    root.right.right = new TreeNode(5);
    return root;
  }

  // Helper: skewed-left chain:  3 -> 2 -> 1
  private TreeNode skewedLeft() {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(1);
    return root;
  }

  // Helper: skewed-right chain:  1 -> 2 -> 3
  private TreeNode skewedRight() {
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.right = new TreeNode(3);
    return root;
  }

  @Test
  @DisplayName("Round-trip: balanced tree should serialize/deserialize identically")
  void roundTripBalancedTree() {
    // Arrange: create tree and codec
    SerializeAndDeserializeBinaryTree codec = new SerializeAndDeserializeBinaryTree();
    TreeNode root = sampleBalanced();

    // Act: serialize, deserialize, then serialize again
    String encoded = codec.serialize(root);
    TreeNode rebuilt = codec.deserialize(encoded);
    String reencoded = codec.serialize(rebuilt);

    // Assert: serialization is stable after a round trip
    assertEquals(encoded, reencoded);
  }

  @Test
  @DisplayName("Round-trip: null/empty tree")
  void roundTripEmptyTree() {
    // Arrange
    SerializeAndDeserializeBinaryTree codec = new SerializeAndDeserializeBinaryTree();
    TreeNode root = null;

    // Act
    String encoded = codec.serialize(root);
    TreeNode rebuilt = codec.deserialize(encoded);
    String reencoded = codec.serialize(rebuilt);

    // Assert
    assertEquals(encoded, reencoded);
  }

  @Test
  @DisplayName("Round-trip: single node and negative values")
  void roundTripSingleAndNegatives() {
    // Arrange: single node with a negative value
    SerializeAndDeserializeBinaryTree codec = new SerializeAndDeserializeBinaryTree();
    TreeNode root = new TreeNode(-7);

    // Act
    String encoded = codec.serialize(root);
    TreeNode rebuilt = codec.deserialize(encoded);
    String reencoded = codec.serialize(rebuilt);

    // Assert
    assertEquals(encoded, reencoded);
  }

  @Test
  @DisplayName("Round-trip: skewed trees (left and right)")
  void roundTripSkewedTrees() {
    // Arrange
    SerializeAndDeserializeBinaryTree codec = new SerializeAndDeserializeBinaryTree();

    // Left-skewed
    String left = codec.serialize(skewedLeft());
    TreeNode leftRebuilt = codec.deserialize(left);
    String leftAgain = codec.serialize(leftRebuilt);
    assertEquals(left, leftAgain);

    // Right-skewed
    String right = codec.serialize(skewedRight());
    TreeNode rightRebuilt = codec.deserialize(right);
    String rightAgain = codec.serialize(rightRebuilt);
    assertEquals(right, rightAgain);
  }
}
