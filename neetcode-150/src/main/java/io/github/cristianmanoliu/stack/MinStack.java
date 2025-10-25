package io.github.cristianmanoliu.stack;

import java.util.Stack;

// https://neetcode.io/problems/minimum-stack?list=neetcode150
// https://leetcode.com/problems/min-stack/
public class MinStack {

  private final Stack<Integer> stack;
  private final Stack<Integer> minStack;

  public MinStack() {
    stack = new Stack<>();
    minStack = new Stack<>();
  }

  public void push(int val) {
    stack.push(val);
    // Push to minStack if it's empty or val is less than or equal to current min
    if (minStack.isEmpty() || val <= minStack.peek()) {
      minStack.push(val);
    } else {
      // Keep the current minimum by pushing it again
      minStack.push(minStack.peek());
    }
  }

  public void pop() {
    stack.pop();
    minStack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return minStack.peek();
  }
}
