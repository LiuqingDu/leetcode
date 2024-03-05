/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {

        int res = 0;
        int profit = 0;
        int n = prices.length;
        int highest = prices[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            if (prices[i] < highest) {
                profit = Math.max(profit, highest - prices[i]);
            }
            if (prices[i] > prices[i + 1]) {
                highest = prices[i];
                res += profit;
                profit = 0;
            }
        }

        res += profit;

        return res;

    }
}
// @lc code=end

