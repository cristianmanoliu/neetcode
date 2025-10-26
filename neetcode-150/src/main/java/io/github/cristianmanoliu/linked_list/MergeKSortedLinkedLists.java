package io.github.cristianmanoliu.linked_list;

import java.util.PriorityQueue;

// https://neetcode.io/problems/merge-k-sorted-linked-lists?list=neetcode150
// https://leetcode.com/problems/merge-k-sorted-lists
public class MergeKSortedLinkedLists {

  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }

    PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
    for (ListNode head : lists) {
      if (head != null) {
        pq.offer(head);
      }
    }

    ListNode dummy = new ListNode(0);
    ListNode tail = dummy;

    while (!pq.isEmpty()) {
      ListNode node = pq.poll();
      tail.next = node;
      tail = tail.next;
      if (node.next != null) {
        pq.offer(node.next);
      }
    }
    return dummy.next;
  }
}
