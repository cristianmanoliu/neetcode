package io.github.cristianmanoliu.sliding_window;

// https://neetcode.io/problems/minimum-window-with-characters?list=neetcode150
public class MinimumWindowSubstring {

  public String minWindow(String s, String t) {
    if (s.length() < t.length()) {
      return "";
    }

    // Count characters in t
    int[] charCount = new int[128];
    for (char c : t.toCharArray()) {
      charCount[c]++;
    }

    int left = 0, right = 0, required = t.length(), minLength = Integer.MAX_VALUE;
    String result = "";

    // Sliding window
    while (right < s.length()) {
      char rightChar = s.charAt(right);
      // If the character is part of t, decrease the required count
      if (charCount[rightChar] > 0) {
        required--;
      }
      // Decrease the count of the character in the map
      charCount[rightChar]--;
      // Move the right pointer to expand the window
      right++;
      // When we have a valid window (all characters in t are found)
      while (required == 0) {
        // Update the result if this window is smaller than the previous one
        if (right - left < minLength) {
          // Update the minimum length and the result substring
          minLength = right - left;
          // Extract the substring from s
          result = s.substring(left, right);
        }

        // Try to contract the window from the left
        char leftChar = s.charAt(left);
        // Increase the count of the character in the map
        charCount[leftChar]++;
        // If the character is part of t, increase the required count
        if (charCount[leftChar] > 0) {
          required++;
        }
        // Move the left pointer to shrink the window
        left++;
      }
    }
    return result;
  }
}
