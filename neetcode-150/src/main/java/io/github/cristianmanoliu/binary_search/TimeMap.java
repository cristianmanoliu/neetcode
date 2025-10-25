package io.github.cristianmanoliu.binary_search;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// https://neetcode.io/problems/time-based-key-value-store?list=neetcode150
// https://leetcode.com/problems/time-based-key-value-store/
public class TimeMap {

  private final Map<String, TreeMap<Integer, String>> map = new HashMap<>();

  public TimeMap() {
    // No initialization needed beyond map
  }

  public void set(String key, String value, int timestamp) {
    map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
  }

  public String get(String key, int timestamp) {
    TreeMap<Integer, String> times = map.get(key);
    if (times == null) {
      return "";
    }
    // floor entry: “latest value at or before timestamp.”
    Map.Entry<Integer, String> e = times.floorEntry(timestamp);
    return e == null ? "" : e.getValue();
  }
}