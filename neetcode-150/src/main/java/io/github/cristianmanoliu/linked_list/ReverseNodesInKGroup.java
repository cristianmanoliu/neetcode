package io.github.cristianmanoliu.linked_list;

// https://neetcode.io/problems/reverse-nodes-in-k-group?list=neetcode150
// https://leetcode.com/problems/reverse-nodes-in-k-group
public class ReverseNodesInKGroup {

  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || k <= 1) {
      return head;
    }

    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode groupPrev = dummy;

    while (true) {
      // Find the kth node from groupPrev (end of current group)
      ListNode kth = getKth(groupPrev, k);
      if (kth == null) {
        break; // fewer than k nodes remain
      }
      ListNode groupNext = kth.next;

      // Reverse the group [groupPrev.next .. kth] in-place
      ListNode prev = groupNext;
      ListNode curr = groupPrev.next;
      while (curr != groupNext) {
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
      }

      // Rewire groupPrev to the new head (kth), and advance groupPrev
      ListNode newGroupHead = kth;
      ListNode newGroupTail = groupPrev.next; // old head becomes tail after reversal
      groupPrev.next = newGroupHead;
      groupPrev = newGroupTail;
    }

    return dummy.next;
  }

  // Returns the kth node starting after 'start' (i.e., start->next is 1st).
  private ListNode getKth(ListNode start, int k) {
    ListNode curr = start;
    for (int i = 0; i < k; i++) {
      if (curr.next == null) {
        return null;
      }
      curr = curr.next;
    }
    return curr;
  }
}
