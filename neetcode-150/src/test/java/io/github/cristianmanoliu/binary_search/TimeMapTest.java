package io.github.cristianmanoliu.binary_search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TimeMapTest {

  @Test
  void example1_timeMap_behavesAsExpected() {
    TimeMap timeMap = new TimeMap();
    timeMap.set("alice", "happy", 1);
    assertEquals("happy", timeMap.get("alice", 1));
    assertEquals("happy", timeMap.get("alice", 2));
    timeMap.set("alice", "sad", 3);
    assertEquals("sad", timeMap.get("alice", 3));
  }
}