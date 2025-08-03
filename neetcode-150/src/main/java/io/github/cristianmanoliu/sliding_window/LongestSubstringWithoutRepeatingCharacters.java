package io.github.cristianmanoliu.sliding_window;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }
    int left = 0;
    int right = 1;
    Set<String> unique = new HashSet<>();
    String leftCharacter = String.valueOf(s.charAt(left));
    unique.add(leftCharacter);
    int maxLength = 1;
    while (right < s.length()) {
      String rightCharacter = String.valueOf(s.charAt(right));
      if (unique.contains(rightCharacter)) {
        left = left + 1;
        right = left + 1;
        leftCharacter = String.valueOf(s.charAt(left));
        unique.clear();
        unique.add(leftCharacter);
      } else {
        unique.add(rightCharacter);
        maxLength = Math.max(maxLength, (1 + right - left));
        right++;
      }
    }
    return maxLength;
  }
}
