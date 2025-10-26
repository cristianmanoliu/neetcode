package io.github.cristianmanoliu.linked_list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class MergeKSortedLinkedListsTest {

  @Test
  public void mergeKLists() {
    MergeKSortedLinkedLists solution = new MergeKSortedLinkedLists();

    // Test case 1: Merging three sorted lists
    ListNode list1 = new ListNode(1);
    list1.next = new ListNode(4);
    list1.next.next = new ListNode(5);

    ListNode list2 = new ListNode(1);
    list2.next = new ListNode(3);
    list2.next.next = new ListNode(4);

    ListNode list3 = new ListNode(2);
    list3.next = new ListNode(6);

    ListNode[] lists = {list1, list2, list3};
    ListNode mergedHead = solution.mergeKLists(lists);

    int[] expectedValues = {1, 1, 2, 3, 4, 4, 5, 6};
    for (int value : expectedValues) {
      assertNotNull(mergedHead);
      assertEquals(value, mergedHead.val);
      mergedHead = mergedHead.next;
    }
    assertNull(mergedHead);

    // Test case 2: Merging an empty array of lists
    ListNode[] emptyLists = {};
    assertNull(solution.mergeKLists(emptyLists));

    // Test case 3: Reconstruct fresh lists (DO NOT REUSE)
    ListNode freshList1 = new ListNode(1);
    freshList1.next = new ListNode(4);
    freshList1.next.next = new ListNode(5);

    ListNode freshList2 = new ListNode(1);
    freshList2.next = new ListNode(3);
    freshList2.next.next = new ListNode(4);

    ListNode[] listsWithEmpty = {null, freshList1, null, freshList2};
    mergedHead = solution.mergeKLists(listsWithEmpty);

    int[] expectedValuesWithEmpty = {1, 1, 3, 4, 4, 5};
    for (int value : expectedValuesWithEmpty) {
      assertNotNull(mergedHead);
      assertEquals(value, mergedHead.val);
      mergedHead = mergedHead.next;
    }
    assertNull(mergedHead);
  }

}