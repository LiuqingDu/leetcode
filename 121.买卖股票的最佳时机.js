/*
 * @lc app=leetcode.cn id=121 lang=javascript
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {

    let n = prices.length;

    let highest = prices[n - 1];
    let res = 0;
    for (let i = n - 2; i >= 0; i--) {
        if (prices[i] < highest) {
            res = Math.max(res, highest - prices[i]);
        } else {
            highest = prices[i];
        }
    }

    return res;

};
// @lc code=end

