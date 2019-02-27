package pers.tavish.solution.hard;

/*

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Example 1:
Input: [2,4,1], k = 2
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.

Example 2:
Input: [3,2,6,5,0,3], k = 2
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
             Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.

for more information: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
*/

public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (k <= 0 || n == 0) {
            return 0;
        }
        
        // validate input 2 : if k is large enough, the question will be the same as question II.
        if (k >= n / 2) {
            int result = 0;
            for (int i = 1; i < n; ++i) {
                if (prices[i] - prices[i - 1] > 0) {
                    result += prices[i] - prices[i - 1];
                }
            }
            return result;
        }
        int[][] localProfit = new int[n][k + 1];
        int[][] globalProfit = new int[n][k + 1];
        
        for (int j = 1; j <= k; ++j) {
            for (int i = 1; i < n; ++i) {
                localProfit[i][j]= Math.max(
                    localProfit[i - 1][j] + prices[i] - prices[i -1], 
                    globalProfit[i - 1][j - 1] + Math.max(0, prices[i] - prices[i - 1]));
                globalProfit[i][j] = Math.max(localProfit[i][j], globalProfit[i - 1][j]);
            }
        }
        return globalProfit[n - 1][k];
    }
}
