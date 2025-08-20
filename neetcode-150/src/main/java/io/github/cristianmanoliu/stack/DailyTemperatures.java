package io.github.cristianmanoliu.stack;

import java.util.Stack;

// https://neetcode.io/problems/daily-temperatures?list=neetcode150
public class DailyTemperatures {

  public int[] dailyTemperatures(int[] temperatures) {
    int[] result = new int[temperatures.length];
    Stack<Temperature> stack = new Stack<>();

    for (int i = 0; i < temperatures.length; i++) {
      while (!stack.isEmpty() && stack.peek().temperature < temperatures[i]) {
        Temperature temp = stack.pop();
        result[temp.index] = i - temp.index;
      }
      stack.push(new Temperature(temperatures[i], i));
    }
    return result;
  }

  record Temperature(int temperature, int index) {

  }
}