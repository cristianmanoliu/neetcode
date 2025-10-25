package io.github.cristianmanoliu.linked_list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class RemoveNodeFromEndOfLinkedListTest {

  @Test
  public void testRemoveNthFromEnd() {
    RemoveNodeFromEndOfLinkedList solution = new RemoveNodeFromEndOfLinkedList();

    // Test case 1: Remove 2nd node from end
    ListNode head1 = new ListNode(1);
    head1.next = new ListNode(2);
    head1.next.next = new ListNode(3);
    head1.next.next.next = new ListNode(4);
    head1.next.next.next.next = new ListNode(5);
    ListNode result1 = solution.removeNthFromEnd(head1, 2);
    assertEquals("1 -> 2 -> 3 -> 5", listToString(result1));

    // Test case 2: Remove head node
    ListNode head2 = new ListNode(1);
    head2.next = new ListNode(2);
    ListNode result2 = solution.removeNthFromEnd(head2, 2);
    assertEquals("2", listToString(result2));

    // Test case 3: Single node list
    ListNode head3 = new ListNode(1);
    ListNode result3 = solution.removeNthFromEnd(head3, 1);
    assertNull(result3);

    // Test case 4: n larger than list length
    ListNode head4 = new ListNode(1);
    head4.next = new ListNode(2);
    ListNode result4 = solution.removeNthFromEnd(head4, 3);
    assertEquals("1 -> 2", listToString(result4));
  }

  private String listToString(ListNode listNode) {
    StringBuilder sb = new StringBuilder();
    ListNode current = listNode;
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