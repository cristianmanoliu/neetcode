package io.github.cristianmanoliu.stack;

// https://neetcode.io/problems/minimum-stack?list=neetcode150
public class MinStack {

  private int min;
  private int[] stack;
  private int index;

  public MinStack() {
    this.min = Integer.MAX_VALUE;
    this.stack = new int[1000]; // assuming a fixed size for simplicity
    this.index = 0; // stack is empty initially
  }

  public void push(int val) {
    if(index >= stack.length) {
      int currentSize = stack.length;
      int[] newStack = new int[currentSize * 2];
      System.arraycopy(stack, 0, newStack, 0, currentSize);
      this.stack = newStack;
    }
    this.stack[this.index] = val;
    this.index++;
    if (val < this.min) {
      this.min = val;
    }
  }

  public void pop() {
    int poppedValue = this.stack[this.index - 1];
    this.index--;
    if (poppedValue == this.min) {
      // Recalculate the minimum value
      this.min = Integer.MAX_VALUE;
      for (int i = 0; i < this.index; i++) {
        if (this.stack[i] < this.min) {
          this.min = this.stack[i];
        }
      }
    }
  }

  public int top() {
    return stack[this.index - 1];
  }

  public int getMin() {
    return min;
  }
}
