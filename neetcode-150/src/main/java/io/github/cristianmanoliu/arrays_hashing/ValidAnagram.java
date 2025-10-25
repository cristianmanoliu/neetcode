package io.github.cristianmanoliu.arrays_hashing;

// https://neetcode.io/problems/is-anagram?list=neetcode150
// https://leetcode.com/problems/valid-anagram/
public class ValidAnagram {

  // Anagram: a word, phrase, or name formed by rearranging the letters of another,
  // such as cinema, formed from iceman.
  public boolean isAnagram(String s, String t) {
    // Early check: different lengths cannot be anagrams
    if (s.length() != t.length()) {
      return false;
    }

    // Frequency array for 26 lowercase English letters
    int[] charCount = new int[26];

    // Count characters in first string (increment)
    for (int i = 0; i < s.length(); i++) {
      charCount[s.charAt(i) - 'a']++;
    }

    // Verify characters in second string (decrement)
    for (int i = 0; i < t.length(); i++) {
      charCount[t.charAt(i) - 'a']--;
      // If count goes negative, character appears more in t than in s
      if (charCount[t.charAt(i) - 'a'] < 0) {
        return false;
      }
    }

    // All counts must be zero (already verified by decrement check above)
    return true;
  }

}
