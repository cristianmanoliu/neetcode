package io.github.cristianmanoliu.uncategorized;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarFleetTest {

  private final CarFleet carFleet = new CarFleet();

  @Test
  void example1() {
    int target = 10;
    int[] position = {1, 4};
    int[] speed = {3, 2};
    int expected = 1;
    assertEquals(expected, carFleet.carFleet(target, position, speed));
  }

  @Test
  void example2() {
    int target = 10;
    int[] position = {4, 1, 0, 7};
    int[] speed = {2, 2, 1, 1};
    int expected = 3;
    assertEquals(expected, carFleet.carFleet(target, position, speed));
  }
}