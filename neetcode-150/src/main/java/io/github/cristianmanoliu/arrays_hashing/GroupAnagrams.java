package io.github.cristianmanoliu.arrays_hashing;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://neetcode.io/problems/anagram-groups?list=neetcode150
public class GroupAnagrams {

  public Collection<List<String>> groupAnagrams(String[] strs) {
    if (strs == null || strs.length == 0) {
      return Collections.emptyList();
    }
    Map<String, List<String>> anagramsMap = new HashMap<>();
    for (String str : strs) {
      char[] charArray = str.toCharArray();
      java.util.Arrays.sort(charArray);
      String key = new String(charArray);
      anagramsMap.computeIfAbsent(key, k -> new java.util.ArrayList<>()).add(str);
    }
    return anagramsMap.values().stream().toList();
  }
}
