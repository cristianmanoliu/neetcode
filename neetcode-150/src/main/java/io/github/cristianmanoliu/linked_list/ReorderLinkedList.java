package io.github.cristianmanoliu.linked_list;

// https://neetcode.io/problems/reorder-linked-list?list=neetcode150
// https://leetcode.com/problems/reorder-list/
public class ReorderLinkedList {

  public void reorderList(ListNode head) {
    if (head == null || head.next == null || head.next.next == null) {
      return;
    }

    // 1) Find end of first half (slow stops at mid-left for even length)
    ListNode slow = head, fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    // slow is at end of first half
    ListNode second = slow.next;
    slow.next = null; // detach to avoid cycles

    // 2) Reverse second half
    ListNode prev = null, curr = second;
    while (curr != null) {
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    ListNode l1 = head;
    ListNode l2 = prev; // head of reversed second half

    // 3) Merge (weave) the two halves: l1, l2, l1.next, l2.next, ...
    while (l2 != null) {
      ListNode n1 = l1.next;
      ListNode n2 = l2.next;

      l1.next = l2;
      l2.next = n1;

      l1 = n1;
      l2 = n2;
    }
  }
}