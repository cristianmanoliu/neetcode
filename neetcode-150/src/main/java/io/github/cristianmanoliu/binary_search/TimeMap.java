package io.github.cristianmanoliu.binary_search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {

  private final Map<String, List<Entry>> map = new HashMap<>();

  private record Entry(String value, int timestamp) {

  }

  public TimeMap() {
    // No initialization needed beyond map
  }

  public void set(String key, String value, int timestamp) {
    map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Entry(value, timestamp));
  }

  public String get(String key, int timestamp) {
    List<Entry> entries = map.get(key);
    if (entries == null) {
      return "";
    }

    int left = 0, right = entries.size() - 1;
    String result = "";
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (entries.get(mid).timestamp <= timestamp) {
        result = entries.get(mid).value;
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return result;
  }
}