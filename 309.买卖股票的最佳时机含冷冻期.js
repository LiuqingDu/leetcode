/*
 * @lc app=leetcode.cn id=309 lang=javascript
 *
 * [309] 买卖股票的最佳时机含冷冻期
 */

// @lc code=start
/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {

    // dp[i][0] 表示当天没有股票且不是当天卖出的
    // dp[i][1] 表示当天持有股票
    // dp[i][2] 表示当天没有股票且是当天卖出的

    // 冷冻期可以理解为，昨天没有卖股票的话，今天才可以买。如果昨天卖了，今天就不可以买

    let n = prices.length;
    let dp = Array.from(new Array(n), () => new Array(3).fill(0));

    dp[0][0] = 0;
    dp[0][1] = -prices[0];
    dp[0][2] = 0;

    for (let i = 1; i < n; i++) {
        // 当天没股票，且不是当天卖出的。两种可能：1，昨天也没有股票；2，昨天卖出了股票
        dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
        // 当天有股票，两种可能：1，昨天有股票dp[i-1][1]；
        //     2，今天买了股票，并且昨天没有股票且没有卖出股票（冷冻期）dp[i-1][0] - prices[i]
        dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        // 当天没有股票，且是当天卖出的。只能是昨天必须已经有股票
        dp[i][2] = dp[i - 1][1] + prices[i];
    }

    return Math.max(dp[n - 1][0], dp[n - 1][2]);
};
// @lc code=end

