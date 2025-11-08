package io.github.cristianmanoliu.binary_search;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * TimeMap (Time-Based Key-Value Store)
 *
 * Problem:
 *  - Support set(key, value, timestamp) and get(key, timestamp)
 *  - get returns the value set for 'key' with the greatest timestamp <= given 'timestamp',
 *    or the empty string if such a value does not exist.
 *
 * Strategy:
 *  - For each key, maintain a monotonic timeline of updates using a TreeMap<Integer, String>
 *    that maps timestamp -> value (timestamps sorted ascending).
 *  - Query with TreeMap.floorEntry(timestamp) to find the latest value at or before 'timestamp'.
 *
 * Complexity:
 *  - Let n_k be the number of updates for a specific key k.
 *  - set:  O(log n_k) due to TreeMap insertion
 *  - get:  O(log n_k) due to TreeMap.floorEntry
 *  - space: O(total number of set operations)
 */
public class TimeMap {

  // Top-level map from key -> (sorted timeline of timestamp -> value)
  // TreeMap keeps timestamps sorted and provides floorEntry in O(log n)
  private final Map<String, TreeMap<Integer, String>> map = new HashMap<>();

  // Constructor: nothing special to initialize beyond the field declaration
  public TimeMap() {
  }

  /**
   * Record that at 'timestamp', 'key' was set to 'value'.
   * If the same (key, timestamp) is inserted multiple times, the last put overwrites.
   *
   * @param key       the logical identifier
   * @param value     the data stored at the timestamp
   * @param timestamp a non-negative integer timestamp (problem constraints)
   */
  public void set(String key, String value, int timestamp) {
    // Lazily create the per-key timeline and insert the (timestamp -> value) pair
    map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
  }

  /**
   * Retrieve the value for 'key' at the latest time <= 'timestamp'.
   * Returns the empty string if 'key' has no assignment at or before 'timestamp'.
   *
   * @param key       the logical identifier to query
   * @param timestamp the target timestamp
   * @return the value at floor timestamp, or "" if not found
   */
  public String get(String key, int timestamp) {
    // Fetch the per-key timeline; if missing, key was never set
    TreeMap<Integer, String> times = map.get(key);
    if (times == null) {
      return "";
    }

    // Find entry with greatest timestamp <= given timestamp; may be null
    Map.Entry<Integer, String> e = times.floorEntry(timestamp);
    return e == null ? "" : e.getValue();
  }
}
