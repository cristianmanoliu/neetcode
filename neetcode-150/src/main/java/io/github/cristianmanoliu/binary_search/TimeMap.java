package io.github.cristianmanoliu.binary_search;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// https://neetcode.io/problems/time-based-key-value-store?list=neetcode150
// https://leetcode.com/problems/time-based-key-value-store/
public class TimeMap {

  // For each key, keep a sorted map from timestamp -> value.
  // TreeMap lets us query the "latest at or before t" via floorEntry(t) in O(log n).
  private final Map<String, TreeMap<Integer, String>> map = new HashMap<>();

  // Constructor: no special initialization required.
  public TimeMap() { }

  // Set the value for 'key' at 'timestamp'.
  // Complexity: O(log n) due to TreeMap insertion.
  public void set(String key, String value, int timestamp) {
    // Create the per-key TreeMap lazily; then insert the (timestamp -> value) pair.
    map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
  }

  // Get the value associated with 'key' at the greatest timestamp <= 'timestamp'.
  // If none exists, return the empty string.
  // Complexity: O(log n) for floorEntry on the per-key TreeMap.
  public String get(String key, int timestamp) {
    // Fetch the per-key timeline
    TreeMap<Integer, String> times = map.get(key);
    if (times == null) {
      return ""; // key not seen
    }
    // floorEntry gives the entry with the greatest key <= timestamp (or null if none)
    Map.Entry<Integer, String> e = times.floorEntry(timestamp);
    return e == null ? "" : e.getValue();
  }
}