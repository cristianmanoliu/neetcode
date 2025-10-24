package io.github.cristianmanoliu.sliding_window;

// https://neetcode.io/problems/permutation-string?list=neetcode150
public class PermutationInString {

  // Permutation means that the characters can be rearranged to form another string.
  public boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length()) {
      return false; // s1 cannot be a permutation of s2 if it's longer
    }

    int l = 0;
    int r = s1.length() - 1;
    while (r < s2.length()) {
      String substring = s2.substring(l, r + 1);
      if (isPermutation(s1, substring)) {
        return true; // Found a permutation of s1 in s2
      }
      l++;
      r++;
    }

    return false;
  }

  private boolean isPermutation(String s1, String substring) {
    if (s1.length() != substring.length()) {
      return false; // If lengths differ, they cannot be permutations
    }

    int[] charCount = new int[26]; // Assuming only lowercase letters a-z

    for (char c : s1.toCharArray()) {
      charCount[c - 'a']++;
    }

    for (char c : substring.toCharArray()) {
      charCount[c - 'a']--;
      if (charCount[c - 'a'] < 0) {
        return false; // More occurrences of c in substring than in s1
      }
    }

    return true; // All counts match, so they are permutations
  }
}
