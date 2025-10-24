package io.github.cristianmanoliu.sliding_window;

// https://neetcode.io/problems/minimum-window-with-characters?list=neetcode150
public class MinimumWindowSubstring {

  public String minWindow(String source, String target) {
    if (source.length() < target.length()) {
      return "";
    }

    // Count characters in target
    int[] charCount = new int[58];
    for (char c : target.toCharArray()) {
      charCount[c]++;
    }

    int left = 0, right = 0, required = target.length(), minLength = Integer.MAX_VALUE;
    String result = "";

    // Sliding window
    while (right < source.length()) {
      char rightChar = source.charAt(right);
      // If the character is part of target, decrease the required count
      if (charCount[rightChar] > 0) {
        required--;
      }
      // Decrease the count of the character in the map
      charCount[rightChar]--;
      // Move the right pointer to expand the window
      right++;
      // When we have a valid window (all characters in target are found)
      while (required == 0) {
        // Update the result if this window is smaller than the previous one
        if (right - left < minLength) {
          // Update the minimum length and the result substring
          minLength = right - left;
          // Extract the substring from source
          result = source.substring(left, right);
        }

        // Try to contract the window from the left
        char leftChar = source.charAt(left);
        // Increase the count of the character in the map
        charCount[leftChar]++;
        // If the character is part of target, increase the required count
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
