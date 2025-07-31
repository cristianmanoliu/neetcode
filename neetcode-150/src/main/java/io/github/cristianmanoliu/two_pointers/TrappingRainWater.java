package io.github.cristianmanoliu.two_pointers;

// https://neetcode.io/problems/trapping-rain-water?list=neetcode150
public class TrappingRainWater {

  public int trapTwoPointer(int[] height) {
    /*
     * ⬜ ⬜ ⬜ ⬛ 🟦 🟦 🟦 ⬛ ⬜ ⬜
     * ⬜ ⬛ 🟦 ⬛ 🟦 🟦 🟦 ⬛ ⬛ ⬜
     * ⬜ ⬛ 🟦 ⬛ ⬛ 🟦 ⬛ ⬛ ⬛ ⬛
     */
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

  public int trapPrefixSuffixMaxima(int[] height) {
    /*
     * ⬜ ⬜ ⬜ ⬛ 🟦 🟦 🟦 ⬛ ⬜ ⬜
     * ⬜ ⬛ 🟦 ⬛ 🟦 🟦 🟦 ⬛ ⬛ ⬜
     * ⬜ ⬛ 🟦 ⬛ ⬛ 🟦 ⬛ ⬛ ⬛ ⬛
     */
    int[] leftMax = new int[height.length];
    int[] rightMax = new int[height.length];
    leftMax[0] = height[0];
    for (int i = 1; i < height.length; i++) {
      leftMax[i] = Math.max(leftMax[i - 1], height[i]);
    }
    rightMax[height.length - 1] = height[height.length - 1];
    for (int i = height.length - 2; i >= 0; i--) {
      rightMax[i] = Math.max(rightMax[i + 1], height[i]);
    }
    int totalArea = 0;
    for (int i = 0; i < height.length; i++) {
      totalArea += Math.max(Math.min(leftMax[i], rightMax[i]) - height[i], 0);
    }
    return totalArea;
  }
}
