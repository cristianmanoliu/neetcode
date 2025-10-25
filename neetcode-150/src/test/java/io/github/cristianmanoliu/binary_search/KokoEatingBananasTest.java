package io.github.cristianmanoliu.binary_search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class KokoEatingBananasTest {

  private final KokoEatingBananas kokoEatingBananas = new KokoEatingBananas();

  @Test
  void example1_minEatingSpeed_returns2() {
    int[] piles = {1, 4, 3, 2};
    int h = 9;
    int expected = 2;
    int result = kokoEatingBananas.minEatingSpeed(piles, h);
    assertEquals(expected, result);
  }

  @Test
  void example2_minEatingSpeed_returns25() {
    int[] piles = {25, 10, 23, 4};
    int h = 4;
    int expected = 25;
    int result = kokoEatingBananas.minEatingSpeed(piles, h);
    assertEquals(expected, result);
  }
}