package io.github.cristianmanoliu.sliding_window;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LongestSubstringWithoutRepeatingCharactersTest {

  private final LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();

  @Test
  void example1_lengthOfLongestSubstring_returns3() {
    String s = "zxyzxyz";
    int result = longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s);
    assertEquals(3, result);
  }

  @Test
  void example2_lengthOfLongestSubstring_returns1() {
    String s = "xxxx";
    int result = longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s);
    assertEquals(1, result);
  }

  @Test
  void additionalTest_abcabcbb_returns3() {
    String s = "abcabcbb";
    int result = longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s);
    assertEquals(3, result);
  }

  @Test
  void additionalTest_bbbbb_returns1() {
    String s = "bbbbb";
    int result = longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s);
    assertEquals(1, result);
  }

  @Test
  void additionalTest_pwwkew_returns3() {
    String s = "pwwkew";
    int result = longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s);
    assertEquals(3, result);
  }

  @Test
  void additionalTest_dvdf_returns3() {
    String s = "dvdf";
    int result = longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s);
    assertEquals(3, result);
  }

  @Test
  void edgeCase_emptyString_returns0() {
    String s = "";
    int result = longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s);
    assertEquals(0, result);
  }
}