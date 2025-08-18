package io.github.cristianmanoliu.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MinStackTest {
  @Test
  public void integrationTest() {
    MinStack minStack = new MinStack();
    minStack.push(1);
    minStack.push(2);
    minStack.push(0);
    assertEquals(0, minStack.getMin()); // return 0
    minStack.pop();
    assertEquals(2, minStack.top());    // return 2
    assertEquals(1, minStack.getMin()); // return 1
  }
}