package io.github.cristianmanoliu.sliding_window;

// https://neetcode.io/problems/permutation-string?list=neetcode150
public class PermutationInString {

  // Permutation means that the characters can be rearranged to form another string.
  public boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length()) {
      return false;
    }

    int[] s1Count = new int[26];
    int[] s2Count = new int[26];

    // Initialize frequency counts for the first window
    for (int i = 0; i < s1.length(); i++) {
      s1Count[s1.charAt(i) - 'a']++;
      s2Count[s2.charAt(i) - 'a']++;
    }

    // Track how many character frequencies match
    int matches = 0;
    for (int i = 0; i < 26; i++) {
      if (s1Count[i] == s2Count[i]) {
        matches++;
      }
    }

    // Slide the window across s2
    int left = 0;
    for (int right = s1.length(); right < s2.length(); right++) {
      if (matches == 26) {
        return true; // All frequencies match
      }

      // Add incoming character (expand window to the right)
      int incomingIdx = s2.charAt(right) - 'a';
      s2Count[incomingIdx]++;
      if (s2Count[incomingIdx] == s1Count[incomingIdx]) {
        matches++;
      } else if (s2Count[incomingIdx] == s1Count[incomingIdx] + 1) {
        matches--; // Was matching, now it's not
      }

      // Remove outgoing character (shrink window from the left)
      int outgoingIdx = s2.charAt(left) - 'a';
      s2Count[outgoingIdx]--;
      if (s2Count[outgoingIdx] == s1Count[outgoingIdx]) {
        matches++;
      } else if (s2Count[outgoingIdx] == s1Count[outgoingIdx] - 1) {
        matches--; // Was matching, now it's not
      }

      left++;
    }

    return matches == 26; // Check the last window
  }
}