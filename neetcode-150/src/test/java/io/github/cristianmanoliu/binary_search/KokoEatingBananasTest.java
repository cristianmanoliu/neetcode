package io.github.cristianmanoliu.binary_search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class KokoEatingBananasTest {

  private final KokoEatingBananas sol = new KokoEatingBananas();

  @Test
  @DisplayName("LeetCode example: [3,6,7,11], h=8 -> 4")
  void example1() {
    assertEquals(4, sol.minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
  }

  @Test
  @DisplayName("Tight hours equal to pile count -> must be max pile")
  void hoursEqualPileCount() {
    assertEquals(11, sol.minEatingSpeed(new int[]{3, 6, 7, 11}, 4));
  }

  @Test
  @DisplayName("Single pile")
  void singlePile() {
    assertEquals(6, sol.minEatingSpeed(new int[]{30}, 5)); // ceil(30/5)=6
    assertEquals(30, sol.minEatingSpeed(new int[]{30}, 1));
  }

  @Test
  @DisplayName("Another classic: [30,11,23,4,20], h=6 -> 23")
  void example2() {
    assertEquals(23, sol.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));
  }

  @Test
  @DisplayName("Speed 1 sufficient when h is large enough")
  void speedOneSufficient() {
    assertEquals(1, sol.minEatingSpeed(new int[]{1, 2, 3, 4}, 10)); // 1+2+3+4=10
  }

  @Test
  @DisplayName("Large values remain within int range")
  void largeValues() {
    assertEquals(500_000_000, sol.minEatingSpeed(new int[]{1_000_000_000}, 2));
  }
}