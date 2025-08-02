package io.github.cristianmanoliu.sliding_window;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BestTimeToBuyAndSellStockTest {

  private final BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();

  @Test
  void example1_maxProfit_returns6() {
    int[] prices = {10, 1, 5, 6, 7, 1};
    int result = bestTimeToBuyAndSellStock.maxProfit(prices);
    assertEquals(6, result);
  }

  @Test
  void example2_maxProfit_returns0() {
    int[] prices = {10, 8, 7, 5, 2};
    int result = bestTimeToBuyAndSellStock.maxProfit(prices);
    assertEquals(0, result);
  }
}