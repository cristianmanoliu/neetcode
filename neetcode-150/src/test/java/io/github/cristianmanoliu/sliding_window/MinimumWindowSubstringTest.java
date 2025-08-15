package io.github.cristianmanoliu.sliding_window;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MinimumWindowSubstringTest {

  private final MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();

  @Test
  void example1_minWindow_returnsYXAZ() {
    String s = "OUZODYXAZV";
    String t = "XYZ";
    String result = minimumWindowSubstring.minWindow(s, t);
    assertEquals("YXAZ", result);
  }

  @Test
  void example2_minWindow_returnsxyz() {
    String s = "xyz";
    String t = "xyz";
    String result = minimumWindowSubstring.minWindow(s, t);
    assertEquals("xyz", result);
  }

  @Test
  void example3_minWindow_returnsEmpty() {
    String s = "x";
    String t = "xy";
    String result = minimumWindowSubstring.minWindow(s, t);
    assertEquals("", result);
  }
}