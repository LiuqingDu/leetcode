/*
 * @lc app=leetcode.cn id=122 lang=javascript
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {

    let n = prices.length;
    let res = 0;
    let profit = 0;
    let highest = prices[n - 1];

    for (let i = n - 2; i >= 0; i--) {
        if (prices[i] < highest) {
            profit = Math.max(profit, highest - prices[i]);
        }
        if (prices[i] > prices[i + 1]) {
            res += profit;
            profit = 0;
            highest = prices[i];
        }
    }

    res += profit;

    return res;

};
// @lc code=end

