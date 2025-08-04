package io.github.cristianmanoliu.sliding_window;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LongestRepeatingCharacterReplacementTest {

  private final LongestRepeatingCharacterReplacement longestRepeatingCharacterReplacement = new LongestRepeatingCharacterReplacement();

  @Test
  void example1_characterReplacement_returns4() {
    String s = "XYYX";
    int k = 2;
    int result = longestRepeatingCharacterReplacement.characterReplacement(s, k);
    assertEquals(4, result);
  }

  @Test
  void example2_characterReplacement_returns5() {
    String s = "AAABABB";
    int k = 1;
    int result = longestRepeatingCharacterReplacement.characterReplacement(s, k);
    assertEquals(5, result);
  }

  @Test
  void additionalTest_AABABBA_k1_returns4() {
    String s = "AABABBA";
    int k = 1;
    int result = longestRepeatingCharacterReplacement.characterReplacement(s, k);
    assertEquals(4, result);
  }
}