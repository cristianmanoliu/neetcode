package io.github.cristianmanoliu.two_pointers;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ValidPalindromeTest {

  private final ValidPalindrome validPalindrome = new ValidPalindrome();

  @Test
  void returnsTrueForWasItACarOrACatISaw() {
    String s = "Was it a car or a cat I saw?";
    assertTrue(validPalindrome.isPalindrome(s));
  }

  @Test
  void returnsFalseForTabACat() {
    String s = "tab a cat";
    assertFalse(validPalindrome.isPalindrome(s));
  }
}