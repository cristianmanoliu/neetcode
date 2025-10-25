package io.github.cristianmanoliu.stack;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ValidParenthesesTest {

  private ValidParentheses validParentheses = new ValidParentheses();

  @Test
  public void tc1() {
    var s = "[]";
    assertTrue(validParentheses.isValid(s));
  }

  @Test
  public void tc2() {
    var s = "([{}])";
    assertTrue(validParentheses.isValid(s));
  }

  @Test
  public void tc3() {
    var s = "[(])";
    assertFalse(validParentheses.isValid(s));
  }

  @Test
  public void tc4() {
    var s = "[";
    assertFalse(validParentheses.isValid(s));
  }

  @Test
  public void tc5() {
    var s = "((";
    assertFalse(validParentheses.isValid(s));
  }
}