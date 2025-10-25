package io.github.cristianmanoliu.stack;

import java.util.Stack;

// https://neetcode.io/problems/daily-temperatures?list=neetcode150
// https://leetcode.com/problems/daily-temperatures
public class DailyTemperatures {

  public int[] dailyTemperatures(int[] temperatures) {
    int[] result = new int[temperatures.length];
    Stack<Integer> stack = new Stack<>();  // Just store indices

    for (int i = 0; i < temperatures.length; i++) {
      while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
        int prevIndex = stack.pop();
        result[prevIndex] = i - prevIndex;
      }
      stack.push(i);  // Just push the index
    }
    return result;
  }

}