package io.github.cristianmanoliu.arrays_hashing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ValidAnagramTest {

  private final ValidAnagram va = new ValidAnagram();

  @Test
  public void testIsAnagram_TrueCase() {
    assertTrue(va.isAnagram("anagram", "nagaram"));
  }

  @Test
  public void testIsAnagram_FalseCase() {
    assertFalse(va.isAnagram("rat", "car"));
  }

  @Test
  public void testIsAnagram_EmptyStrings() {
    assertTrue(va.isAnagram("", ""));
  }

  @Test
  public void testIsAnagram_DifferentLengths() {
    assertFalse(va.isAnagram("a", "ab"));
  }

  @Test
  public void testIsAnagram_SameLettersDifferentCounts() {
    assertFalse(va.isAnagram("aabb", "ab"));
  }
}