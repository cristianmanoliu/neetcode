package io.github.cristianmanoliu.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CarFleetTest {

  @Test
  public void testCarFleet() {
    CarFleet cf = new CarFleet();

    int result1 = cf.carFleet(12, new int[]{10, 8, 0, 5, 3}, new int[]{2, 4, 1, 1, 3});
    assertEquals(3, result1);

    int result2 = cf.carFleet(10, new int[]{3}, new int[]{3});
    assertEquals(1, result2);

    int result3 = cf.carFleet(100, new int[]{0, 2, 4}, new int[]{4, 2, 1});
    assertEquals(1, result3);
  }

}