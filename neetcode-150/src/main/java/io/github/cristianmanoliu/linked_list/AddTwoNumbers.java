package io.github.cristianmanoliu.linked_list;

// https://neetcode.io/problems/add-two-numbers?list=neetcode150
// https://leetcode.com/problems/add-two-numbers
public class AddTwoNumbers {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode tail = dummy;
    int carry = 0;

    while (l1 != null || l2 != null || carry != 0) {
      int x = (l1 != null) ? l1.val : 0;
      int y = (l2 != null) ? l2.val : 0;
      int sum = x + y + carry;

      carry = sum / 10;
      tail.next = new ListNode(sum % 10);
      tail = tail.next;

      if (l1 != null) {
        l1 = l1.next;
      }
      if (l2 != null) {
        l2 = l2.next;
      }
    }
    return dummy.next;
  }
}
