package io.github.cristianmanoliu.arrays_hashing;

// https://neetcode.io/problems/is-anagram?list=neetcode150
// https://leetcode.com/problems/valid-anagram/
public class ValidAnagram {

  // Main function: check if strings s and t are anagrams.
  // Assumption (per problem): inputs contain only lowercase English letters 'a'..'z'.
  public boolean isAnagram(String s, String t) {
    // Early exit: different lengths cannot be anagrams
    if (s.length() != t.length()) {
      return false;
    }

    // Frequency array for 26 lowercase letters
    int[] charCount = new int[26];

    // Count each character from s (increment)
    for (int i = 0; i < s.length(); i++) {
      charCount[s.charAt(i) - 'a']++;
    }

    // Subtract counts using t (decrement)
    // If any count goes negative, t has more of that char than s -> not an anagram
    for (int i = 0; i < t.length(); i++) {
      int idx = t.charAt(i) - 'a';
      if (--charCount[idx] < 0) {
        return false;
      }
    }

    // All counts balanced to zero -> an anagram
    return true;
  }
}
