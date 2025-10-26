package io.github.cristianmanoliu.linked_list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class CopyLinkedListWithRandomPointerTest {

  @Test
  void copyRandomList() {
    CopyLinkedListWithRandomPointer solution = new CopyLinkedListWithRandomPointer();

    // Test case 1: Empty list
    Node head1 = null;
    Node copiedList1 = solution.copyRandomList(head1);
    assertNull(copiedList1);

    // Test case 2: Single node with no random pointer
    Node head2 = new Node(1);
    Node copiedList2 = solution.copyRandomList(head2);
    assertNotNull(copiedList2);
    assertEquals(1, copiedList2.val);
    assertNull(copiedList2.next);
    assertNull(copiedList2.random);

    // Test case 3: Single node with random pointer to itself
    Node head3 = new Node(1);
    head3.random = head3;
    Node copiedList3 = solution.copyRandomList(head3);
    assertNotNull(copiedList3);
    assertEquals(1, copiedList3.val);
    assertNull(copiedList3.next);
    assertEquals(copiedList3, copiedList3.random);

    // Test case 4: Multiple nodes with various random pointers
    Node head4 = new Node(1);
    head4.next = new Node(2);
    head4.next.next = new Node(3);
    head4.random = head4.next.next; // 1 -> 3
    head4.next.random = head4;       // 2 -> 1
    head4.next.next.random = head4.next; // 3 -> 2

    Node copiedList4 = solution.copyRandomList(head4);
    assertNotNull(copiedList4);
    assertEquals(1, copiedList4.val);
    assertEquals(2, copiedList4.next.val);
    assertEquals(3, copiedList4.next.next.val);
    assertEquals(copiedList4.next.next, copiedList4.random); // 1 -> 3
    assertEquals(copiedList4, copiedList4.next.random);       // 2 -> 1
    assertEquals(copiedList4.next, copiedList4.next.next.random); // 3 -> 2
  }
}