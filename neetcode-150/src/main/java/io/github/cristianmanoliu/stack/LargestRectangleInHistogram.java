package io.github.cristianmanoliu.stack;

import java.util.Stack;

// https://neetcode.io/problems/largest-rectangle-in-histogram?list=neetcode150
public class  LargestRectangleInHistogram {
  public int largestRectangleArea(int[] heights) {
    Stack<HeightIndex> stack = new Stack<>();
    int maxArea = 0;
    int n = heights.length;

    for (int i = 0; i <= n; i++) {
      int currentHeight = (i == n) ? 0 : heights[i];
      while (!stack.isEmpty() && stack.peek().height > currentHeight) {
        HeightIndex heightIndex = stack.pop();
        int height = heightIndex.height;
        int width = (stack.isEmpty()) ? i : i - stack.peek().index - 1;
        maxArea = Math.max(maxArea, height * width);
      }
      stack.push(new HeightIndex(currentHeight, i));
    }

    return maxArea;
  }

  private record HeightIndex(int height, int index) {
    // This record holds the height and its index in the histogram.
  }
}
