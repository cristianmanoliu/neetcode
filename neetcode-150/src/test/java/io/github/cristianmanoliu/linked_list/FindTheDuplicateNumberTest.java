package io.github.cristianmanoliu.linked_list;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FindTheDuplicateNumberTest {

  @Test
  void findDuplicate() {
    FindTheDuplicateNumber solution = new FindTheDuplicateNumber();

    // Test case 1
    int[] nums1 = {1, 3, 4, 2, 2};
    assertEquals(2, solution.findDuplicate(nums1));

    // Test case 2
    int[] nums2 = {3, 1, 3, 4, 2};
    assertEquals(3, solution.findDuplicate(nums2));

    // Test case 3
    int[] nums3 = {1, 1};
    assertEquals(1, solution.findDuplicate(nums3));

    // Test case 4
    int[] nums4 = {1, 4, 4, 2, 4};
    assertEquals(4, solution.findDuplicate(nums4));
  }
}