package io.github.cristianmanoliu.sliding_window;

// https://neetcode.io/problems/buy-and-sell-crypto?list=neetcode150
public class BestTimeToBuyAndSellStock {

  public int maxProfit(int[] prices) {
    // the day on which we would buy
    int l = 0;
    // the day on which we would sell
    int r = 1;
    int maxProfit = 0;
    while (r < prices.length) {
      if (prices[l] < prices[r]) {
        int profit = prices[r] - prices[l];
        maxProfit = Math.max(maxProfit, profit);
      } else {
        l = r;
      }
      r++;
    }
    return maxProfit;
  }
}
