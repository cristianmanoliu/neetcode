package io.github.cristianmanoliu.linked_list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class ReverseNodesInKGroupTest {

  @Test
  public void reverseKGroup() {
    ReverseNodesInKGroup solution = new ReverseNodesInKGroup();

    // Test case 1
    ListNode head1 = new ListNode(1);
    head1.next = new ListNode(2);
    head1.next.next = new ListNode(3);
    head1.next.next.next = new ListNode(4);
    head1.next.next.next.next = new ListNode(5);
    int k1 = 2;
    ListNode result1 = solution.reverseKGroup(head1, k1);
    int[] expected1 = {2, 1, 4, 3, 5};
    for (int val : expected1) {
      assertNotNull(result1);
      assertEquals(val, result1.val);
      result1 = result1.next;
    }

    // Test case 2
    ListNode head2 = new ListNode(1);
    head2.next = new ListNode(2);
    head2.next.next = new ListNode(3);
    head2.next.next.next = new ListNode(4);
    head2.next.next.next.next = new ListNode(5);
    int k2 = 3;
    ListNode result2 = solution.reverseKGroup(head2, k2);
    int[] expected2 = {3, 2, 1, 4, 5};
    for (int val : expected2) {
      assertNotNull(result2);
      assertEquals(val, result2.val);
      result2 = result2.next;
    }
  }

}