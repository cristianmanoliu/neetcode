package io.github.cristianmanoliu.two_pointers;

// https://neetcode.io/problems/trapping-rain-water?list=neetcode150
public class TrappingRainWater {

  public int trap(int[] height) {
    int left = 0, right = height.length - 1;
    int leftMax = 0, rightMax = 0, totalArea = 0;
    while (left < right) {
      if (height[left] < height[right]) {
        if (height[left] >= leftMax) {
          leftMax = height[left];
        } else {
          totalArea += leftMax - height[left];
        }
        left++;
      } else {
        if (height[right] >= rightMax) {
          rightMax = height[right];
        } else {
          totalArea += rightMax - height[right];
        }
        right--;
      }
    }
    return totalArea;
  }
}
