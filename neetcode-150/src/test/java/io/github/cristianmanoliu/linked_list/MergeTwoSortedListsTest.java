package io.github.cristianmanoliu.linked_list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class MergeTwoSortedListsTest {

  @Test
  public void testMergeTwoLists() {
    MergeTwoSortedLists merger = new MergeTwoSortedLists();

    ListNode l1 = new ListNode(1,
        new ListNode(3,
            new ListNode(5)));

    ListNode l2 = new ListNode(2,
        new ListNode(4,
            new ListNode(6)));

    ListNode mergedHead = merger.mergeTwoLists(l1, l2);

    assertEquals(1, mergedHead.val);
    assertEquals(2, mergedHead.next.val);
    assertEquals(3, mergedHead.next.next.val);
    assertEquals(4, mergedHead.next.next.next.val);
    assertEquals(5, mergedHead.next.next.next.next.val);
    assertEquals(6, mergedHead.next.next.next.next.next.val);
    assertNull(mergedHead.next.next.next.next.next.next);
  }

}