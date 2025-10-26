package io.github.cristianmanoliu.linked_list;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class LinkedListCycleTest {

  @Test
  public void hasCycle() {
    LinkedListCycle solution = new LinkedListCycle();

    // Test case 1: No cycle
    ListNode head1 = new ListNode(3);
    head1.next = new ListNode(2);
    head1.next.next = new ListNode(0);
    head1.next.next.next = new ListNode(-4);
    assertFalse(solution.hasCycle(head1));

    // Test case 2: Cycle exists
    ListNode head2 = new ListNode(1);
    head2.next = new ListNode(2);
    head2.next.next = head2; // Creates a cycle
    assertTrue(solution.hasCycle(head2));

    // Test case 3: Single node, no cycle
    ListNode head3 = new ListNode(1);
    assertFalse(solution.hasCycle(head3));

    // Test case 4: Single node, cycle to itself
    ListNode head4 = new ListNode(1);
    head4.next = head4; // Creates a cycle
    assertTrue(solution.hasCycle(head4));
  }
}