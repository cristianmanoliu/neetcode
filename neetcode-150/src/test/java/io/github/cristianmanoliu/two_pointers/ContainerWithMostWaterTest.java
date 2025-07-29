package io.github.cristianmanoliu.two_pointers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ContainerWithMostWaterTest {

  private final ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();

  @Test
  void returnsThirtySixForExampleOne() {
    int[] height = {1, 7, 2, 5, 4, 7, 3, 6};
    int expected = 36;
    int result = containerWithMostWater.maxArea(height);
    assertEquals(expected, result);
  }

  @Test
  void returnsFourForExampleTwo() {
    int[] height = {2, 2, 2};
    int expected = 4;
    int result = containerWithMostWater.maxArea(height);
    assertEquals(expected, result);
  }
}