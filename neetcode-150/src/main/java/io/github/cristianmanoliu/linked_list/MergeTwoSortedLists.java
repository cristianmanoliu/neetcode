package io.github.cristianmanoliu.linked_list;

// https://neetcode.io/problems/merge-two-sorted-linked-lists?list=neetcode150
// https://leetcode.com/problems/merge-two-sorted-lists/
public class MergeTwoSortedLists {

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if (list1 == null) {
      return list2;
    }
    if (list2 == null) {
      return list1;
    }

    if (list1 == list2) {
      return list1; // avoid cycles when inputs alias
    }

    ListNode dummy = new ListNode(0);
    ListNode tail = dummy;

    ListNode p1 = list1;
    ListNode p2 = list2;

    while (p1 != null && p2 != null) {
      if (p1.val <= p2.val) {
        tail.next = p1;
        p1 = p1.next;
      } else {
        tail.next = p2;
        p2 = p2.next;
      }
      tail = tail.next;
    }

    tail.next = (p1 != null) ? p1 : p2;
    return dummy.next;
  }
}
