package io.github.cristianmanoliu.arrays_hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://neetcode.io/problems/anagram-groups?list=neetcode150
// https://leetcode.com/problems/group-anagrams
public class GroupAnagrams {

  // Main function: group words that are anagrams of each other.
  // Strategy: For each string, compute a frequency-based key (26-length histogram for 'a'..'z').
  // Use that key in a hash map to collect all strings with identical character counts.
  public List<List<String>> groupAnagrams(String[] strs) {
    // Map: signature (frequency key) -> list of words sharing that signature
    Map<String, List<String>> anagramGroups = new HashMap<>();

    // Process each string and append it into its group
    for (String str : strs) {
      // Build the frequency signature key for this string
      String key = generateFrequencyKey(str);

      // Add the string to the bucket for this key (create bucket if missing)
      anagramGroups.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
    }

    // Return all grouped anagram lists
    return new ArrayList<>(anagramGroups.values());
  }

  // Helper: build a compact frequency key for lowercase ASCII letters 'a'..'z'.
  // Example: "abbccc" -> "a1b2c3"
  private String generateFrequencyKey(String str) {
    // Count of each letter (assumes input is lowercase a..z per problem constraints)
    int[] charCount = new int[26];

    // Count character frequencies
    for (char c : str.toCharArray()) {
      charCount[c - 'a']++;
    }

    // Build a compact key only for letters that appear (letter followed by count)
    StringBuilder key = new StringBuilder();
    for (int i = 0; i < 26; i++) {
      if (charCount[i] > 0) {
        key.append((char) ('a' + i)).append(charCount[i]);
      }
    }

    return key.toString();
  }
}