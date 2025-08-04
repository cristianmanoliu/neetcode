package io.github.cristianmanoliu.sliding_window;

public class LongestRepeatingCharacterReplacement {

  public int characterReplacement(String s, int k) {
    if (s == null || s.isEmpty() || k < 0) {
      return 0;
    }
    int answer = 0;
    int[] freq = new int[26];
    int maxFreq = 0;
    int left = 0;
    for (int right = 0; right < s.length(); right++) {
      char c = s.charAt(right);
      freq[c - 'A']++;
      maxFreq = Math.max(maxFreq, freq[c - 'A']);
      while ((right - left + 1) - maxFreq > k) {
        char leftChar = s.charAt(left);
        freq[leftChar - 'A']--;
        left++;
      }
      answer = Math.max(answer, right - left + 1);
    }
    return answer;
  }
}