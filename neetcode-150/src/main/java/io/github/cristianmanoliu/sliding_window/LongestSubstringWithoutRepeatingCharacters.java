package io.github.cristianmanoliu.sliding_window;

import java.util.HashSet;
import java.util.Set;

// https://neetcode.io/problems/longest-substring-without-duplicates?list=neetcode150
public class LongestSubstringWithoutRepeatingCharacters {

  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }
    int maxLength = 0;
    int leftSlider = 0;
    Set<String> seenChars = new HashSet<>();
    for (int rightSlider = 0; rightSlider < s.length(); rightSlider++) {
      String rightChar = String.valueOf(s.charAt(rightSlider));
      // If the character is already seen, move the left slider
      while (seenChars.contains(rightChar)) {
        String leftChar = String.valueOf(s.charAt(leftSlider));
        seenChars.remove(leftChar);
        leftSlider++;
      }
      // Add the current character to the set
      seenChars.add(rightChar);
      // Calculate the maximum length of substring without repeating characters
      maxLength = Math.max(maxLength, rightSlider - leftSlider + 1);
    }
    return maxLength;
  }
}
