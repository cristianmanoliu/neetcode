package io.github.cristianmanoliu.linked_list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class ReorderLinkedListTest {

  @Test
  public void testReorderList() {
    ReorderLinkedList solution = new ReorderLinkedList();

    // Test case 1: Even number of nodes
    ListNode head1 = new ListNode(1);
    head1.next = new ListNode(2);
    head1.next.next = new ListNode(3);
    head1.next.next.next = new ListNode(4);
    solution.reorderList(head1);
    assertEquals("1 -> 4 -> 2 -> 3", listToString(head1));

    // Test case 2: Odd number of nodes
    ListNode head2 = new ListNode(1);
    head2.next = new ListNode(2);
    head2.next.next = new ListNode(3);
    head2.next.next.next = new ListNode(4);
    head2.next.next.next.next = new ListNode(5);
    solution.reorderList(head2);
    assertEquals("1 -> 5 -> 2 -> 4 -> 3", listToString(head2));

    // Test case 3: Single node
    ListNode head3 = new ListNode(1);
    solution.reorderList(head3);
    assertEquals("1", listToString(head3));

    // Test case 4: Empty list
    ListNode head4 = null;
    solution.reorderList(head4);
    assertNull(head4);
  }

  private String listToString(ListNode head) {
    StringBuilder sb = new StringBuilder();
    ListNode current = head;
    while (current != null) {
      sb.append(current.val);
      if (current.next != null) {
        sb.append(" -> ");
      }
      current = current.next;
    }
    return sb.toString();
  }

}