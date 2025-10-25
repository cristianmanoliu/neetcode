package io.github.cristianmanoliu.linked_list;

// https://neetcode.io/problems/reverse-a-linked-list?list=neetcode150
// https://leetcode.com/problems/reverse-linked-list
public class ReverseLinkedList {

  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;

    while (curr != null) {
      ListNode next = curr.next; // save next
      curr.next = prev;          // reverse link
      prev = curr;               // advance prev
      curr = next;               // advance curr
    }

    return prev; // new head
  }
}
