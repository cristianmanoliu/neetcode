package io.github.cristianmanoliu.arrays_hashing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ContainsDuplicateTest {

  private final ContainsDuplicate containsDuplicate = new ContainsDuplicate();

  @Test
  void hasDuplicate() {
    assertTrue(containsDuplicate.hasDuplicate(new int[]{1, 2, 3, 3}));
  }

  @Test
  void doesNotHaveDuplicate() {
    assertFalse(containsDuplicate.hasDuplicate(new int[]{1, 2, 3, 4}));
  }
}