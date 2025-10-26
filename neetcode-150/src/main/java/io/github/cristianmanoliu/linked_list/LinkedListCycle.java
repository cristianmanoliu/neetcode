package io.github.cristianmanoliu.linked_list;

// https://neetcode.io/problems/linked-list-cycle-detection?list=neetcode150
// https://leetcode.com/problems/linked-list-cycle
public class LinkedListCycle {

  public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) {
      return false;
    }

    ListNode slow = head, fast = head.next; // or both at head; either works with adjusted loop
    while (fast != null && fast.next != null) {
      if (slow == fast) {
        return true;
      }
      slow = slow.next;
      fast = fast.next.next;
    }
    return false;
  }
}
