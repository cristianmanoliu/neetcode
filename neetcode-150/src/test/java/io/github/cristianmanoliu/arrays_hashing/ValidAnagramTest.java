package io.github.cristianmanoliu.arrays_hashing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidAnagramTest {

  private final ValidAnagram sol = new ValidAnagram();

  @Test
  @DisplayName("Empty strings are anagrams")
  void emptyStrings() {
    assertTrue(sol.isAnagram("", ""));
  }

  @Test
  @DisplayName("Classic positive: anagram vs nagaram")
  void classicPositive() {
    assertTrue(sol.isAnagram("anagram", "nagaram"));
  }

  @Test
  @DisplayName("Different lengths -> false")
  void differentLengths() {
    assertFalse(sol.isAnagram("rat", "carp"));
  }

  @Test
  @DisplayName("Same length but different counts -> false")
  void sameLengthDifferentCounts() {
    assertFalse(sol.isAnagram("aab", "abb"));
  }

  @Test
  @DisplayName("Reordered same multiset -> true")
  void reorderedSameMultiset() {
    assertTrue(sol.isAnagram("aabbcc", "baccab"));
  }

  @Test
  @DisplayName("Single characters equal vs. different")
  void singleChars() {
    assertTrue(sol.isAnagram("a", "a"));
    assertFalse(sol.isAnagram("a", "b"));
  }

  @Test
  @DisplayName("Many repeats")
  void manyRepeats() {
    assertTrue(sol.isAnagram("zzzzaaaa", "aazzzaza".replace(" ", ""))); // both 4 z's, 4 a's
  }
}
