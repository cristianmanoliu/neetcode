package io.github.cristianmanoliu.linked_list;

// https://neetcode.io/problems/remove-node-from-end-of-linked-list?list=neetcode150
// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class RemoveNodeFromEndOfLinkedList {

  public ListNode removeNthFromEnd(ListNode head, int n) {
    // Dummy simplifies deletion (including head removal)
    ListNode dummy = new ListNode(0, head);
    ListNode slow = dummy, fast = dummy;

    // Create a gap of n+1 nodes between fast and slow
    for (int i = 0; i <= n; i++) {
      if (fast == null) {
        // n is larger than length; return original head unchanged
        return head;
      }
      fast = fast.next;
    }

    // Move both pointers until fast hits the end
    while (fast != null) {
      fast = fast.next;
      slow = slow.next;
    }

    // slow is just before the node to delete
    if (slow.next != null) {
      slow.next = slow.next.next;
    }

    return dummy.next;
  }
}