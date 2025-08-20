package io.github.cristianmanoliu.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DailyTemperaturesTest {

  private final DailyTemperatures dailyTemperatures = new DailyTemperatures();

  @Test
  public void example1() {
    var temperatures = new int[] {30,38,30,36,35,40,28};
    var expected = new int[] {1,4,1,2,1,0,0};
    assertArrayEquals(expected, dailyTemperatures.dailyTemperatures(temperatures));
  }
}