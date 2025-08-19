package io.github.cristianmanoliu.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EvaluateReversePolishNotationTest {
  private EvaluateReversePolishNotation evaluateReversePolishNotation = new EvaluateReversePolishNotation();

  @Test
  public void example1() {
    var tokens = new String[]{"1","2","+","3","*","4","-"};
    assertEquals(5, evaluateReversePolishNotation.evalRPN(tokens));
  }

}