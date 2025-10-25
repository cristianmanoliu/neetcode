package io.github.cristianmanoliu.arrays_hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://neetcode.io/problems/anagram-groups?list=neetcode150
// https://leetcode.com/problems/group-anagrams
public class GroupAnagrams {

  /**
   * Groups anagrams together using character frequency array as hash key.
   * <p>
   * Time: O(n × k) where n = number of strings, k = max string length
   * <p>
   * Space: O(n × k) for storing all strings in the hash map
   */
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> anagramGroups = new HashMap<>();

    for (String str : strs) {
      // Generate frequency-based key
      String key = generateFrequencyKey(str);

      // Add string to the appropriate group
      anagramGroups.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
    }

    return new ArrayList<>(anagramGroups.values());
  }

  /**
   * Generates a unique key based on character frequency.
   * <p>
   * Example: "aab" -> "2a1b" or "a2b1" (order doesn't matter, just consistency)
   */
  private String generateFrequencyKey(String str) {
    int[] charCount = new int[26];

    // Count character frequencies
    for (char c : str.toCharArray()) {
      charCount[c - 'a']++;
    }

    // Build key from frequency array
    StringBuilder key = new StringBuilder();
    for (int i = 0; i < 26; i++) {
      if (charCount[i] > 0) {
        key.append((char) ('a' + i)).append(charCount[i]);
      }
    }

    return key.toString();
  }
}
