package io.github.cristianmanoliu.linked_list;

public class Node {

  final int val;
  Node next;
  Node random;

  public Node(int val) {
    this.val = val;
    this.next = null;
    this.random = null;
  }
}