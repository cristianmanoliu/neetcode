package io.github.cristianmanoliu.linked_list;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class AddTwoNumbersTest {

  // Helper to build a list from digits (least-significant digit first)
  private static ListNode build(int... vals) {
    if (vals == null || vals.length == 0) {
      return null;
    }
    ListNode head = new ListNode(vals[0]);
    ListNode cur = head;
    for (int i = 1; i < vals.length; i++) {
      cur.next = new ListNode(vals[i]);
      cur = cur.next;
    }
    return head;
  }

  // Helper to convert a list to an int array of digits (least-significant first)
  private static int[] toArray(ListNode node) {
    if (node == null) {
      return null;
    }
    java.util.List<Integer> tmp = new java.util.ArrayList<>();
    for (ListNode cur = node; cur != null; cur = cur.next) {
      tmp.add(cur.val);
    }
    int[] out = new int[tmp.size()];
    for (int i = 0; i < tmp.size(); i++) {
      out[i] = tmp.get(i);
    }
    return out;
  }

  @Test
  void addsTwoNonEmptyLists() {
    ListNode l1 = build(2, 4, 3); // represents 342
    ListNode l2 = build(5, 6, 4); // represents 465

    AddTwoNumbers solver = new AddTwoNumbers();
    ListNode result = solver.addTwoNumbers(l1, l2);

    assertArrayEquals(new int[]{7, 0, 8}, toArray(result)); // represents 807
  }

  @Test
  void handlesNullInputs() {
    AddTwoNumbers solver = new AddTwoNumbers();

    assertNull(solver.addTwoNumbers(null, null));

    ListNode singleZero = build(0);
    assertArrayEquals(new int[]{0}, toArray(solver.addTwoNumbers(singleZero, null)));

    ListNode one = build(1);
    ListNode ninetyNine = build(9, 9);
    assertArrayEquals(new int[]{0, 0, 1}, toArray(solver.addTwoNumbers(ninetyNine, one))); // 99 + 1 = 100
  }
}
