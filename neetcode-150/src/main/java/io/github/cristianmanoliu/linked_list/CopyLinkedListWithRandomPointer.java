package io.github.cristianmanoliu.linked_list;

// https://neetcode.io/problems/copy-linked-list-with-random-pointer?list=neetcode150
// https://leetcode.com/problems/copy-list-with-random-pointer
public class CopyLinkedListWithRandomPointer {

  public Node copyRandomList(Node head) {
    if (head == null) {
      return null;
    }

    // 1) Interleave cloned nodes after originals: A->A'->B->B'->...
    for (Node curr = head; curr != null; curr = curr.next.next) {
      Node clone = new Node(curr.val);
      clone.next = curr.next;
      curr.next = clone;
    }

    // 2) Assign random pointers for clones using interleaving
    for (Node curr = head; curr != null; curr = curr.next.next) {
      Node clone = curr.next;
      clone.random = (curr.random != null) ? curr.random.next : null;
    }

    // 3) Detach clones to form the copied list; restore original list
    Node pseudoHead = new Node(0);
    Node copyCurr = pseudoHead;
    Node curr = head;
    while (curr != null) {
      Node clone = curr.next;
      Node nextOrig = clone.next; // original next

      // extract clone
      copyCurr.next = clone;
      copyCurr = clone;

      // restore original
      curr.next = nextOrig;
      curr = nextOrig;
    }

    return pseudoHead.next;
  }
}