package io.github.cristianmanoliu.linked_list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class ReverseLinkedListTest {

  @Test
  public void testReverseList() {
    ReverseLinkedList reverseLinkedList = new ReverseLinkedList();

    ListNode head = new ListNode(1,
        new ListNode(2,
            new ListNode(3,
                new ListNode(4,
                    new ListNode(5)))));

    ListNode reversedHead = reverseLinkedList.reverseList(head);

    assertEquals(5, reversedHead.val);
    assertEquals(4, reversedHead.next.val);
    assertEquals(3, reversedHead.next.next.val);
    assertEquals(2, reversedHead.next.next.next.val);
    assertEquals(1, reversedHead.next.next.next.next.val);
    assertNull(reversedHead.next.next.next.next.next);
  }

}