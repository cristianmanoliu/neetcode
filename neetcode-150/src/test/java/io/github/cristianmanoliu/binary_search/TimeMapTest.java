package io.github.cristianmanoliu.binary_search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// JUnit 5 tests for TimeMap
class TimeMapTest {

  @Test
  @DisplayName("Get before any set -> empty string")
  void getBeforeAnySet() {
    TimeMap tm = new TimeMap();
    assertEquals("", tm.get("foo", 10));
  }

  @Test
  @DisplayName("Exact timestamp matches the set value")
  void exactTimestamp() {
    TimeMap tm = new TimeMap();
    tm.set("foo", "bar", 1);
    tm.set("foo", "bar2", 5);

    assertEquals("bar", tm.get("foo", 1));
    assertEquals("bar2", tm.get("foo", 5));
  }

  @Test
  @DisplayName("Query between timestamps returns the latest value <= timestamp")
  void betweenTimestamps() {
    TimeMap tm = new TimeMap();
    tm.set("foo", "a", 2);
    tm.set("foo", "b", 4);
    tm.set("foo", "c", 8);

    // Between 2 and 4 -> "a" at t=3
    assertEquals("a", tm.get("foo", 3));
    // Between 4 and 8 -> "b" at t=6
    assertEquals("b", tm.get("foo", 6));
    // After last -> "c"
    assertEquals("c", tm.get("foo", 100));
  }

  @Test
  @DisplayName("Different keys are independent")
  void multipleKeys() {
    TimeMap tm = new TimeMap();
    tm.set("x", "alpha", 1);
    tm.set("y", "beta", 1);
    tm.set("x", "gamma", 3);

    assertEquals("alpha", tm.get("x", 2));
    assertEquals("gamma", tm.get("x", 3));
    assertEquals("beta", tm.get("y", 5));
    assertEquals("", tm.get("z", 1)); // unknown key
  }

  @Test
  @DisplayName("Same timestamp overwrite behavior (TreeMap last write wins)")
  void sameTimestampOverwrite() {
    TimeMap tm = new TimeMap();
    tm.set("k", "v1", 7);
    tm.set("k", "v2", 7); // same timestamp; TreeMap overwrites

    assertEquals("v2", tm.get("k", 7));
    assertEquals("v2", tm.get("k", 100));
  }

  @Test
  @DisplayName("Earliest timestamp boundary")
  void earliestBoundary() {
    TimeMap tm = new TimeMap();
    tm.set("a", "first", 10);
    tm.set("a", "second", 20);

    // Before earliest -> empty
    assertEquals("", tm.get("a", 9));
    // At earliest -> first
    assertEquals("first", tm.get("a", 10));
    // After earliest but before next -> first
    assertEquals("first", tm.get("a", 15));
  }
}