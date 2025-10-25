package io.github.cristianmanoliu.sliding_window;

// https://neetcode.io/problems/minimum-window-with-characters?list=neetcode150
public class MinimumWindowSubstring {

  public String minWindow(String source, String target) {
    if (source.length() < target.length()) {
      return "";
    }

    int[] charCount = new int[58];
    for (char c : target.toCharArray()) {
      charCount[c - 'A']++;
    }

    int left = 0, required = target.length();
    int minStart = 0, minEnd = Integer.MAX_VALUE;

    for (int right = 0; right < source.length(); right++) {
      char rightChar = source.charAt(right);
      if (charCount[rightChar - 'A'] > 0) {
        required--;
      }
      charCount[rightChar - 'A']--;

      while (required == 0) {
        if (right - left < minEnd - minStart) {
          minStart = left;
          minEnd = right;
        }

        char leftChar = source.charAt(left);
        charCount[leftChar - 'A']++;
        if (charCount[leftChar - 'A'] > 0) {
          required++;
        }
        left++;
      }
    }

    return minEnd == Integer.MAX_VALUE ? "" : source.substring(minStart, minEnd + 1);
  }
}
