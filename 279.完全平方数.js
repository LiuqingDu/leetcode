/*
 * @lc app=leetcode.cn id=279 lang=javascript
 *
 * [279] 完全平方数
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var numSquares = function(n) {

    let dp = Array(n + 1).fill(n);

    dp[0] = 0;

    for (let i = 1; i <= n; i++) {
        for (let j = 1; j*j <= i; j++) {
            dp[i] = Math.min(dp[i - j*j] + 1, dp[i]);
        }
    }

    return dp[n];

};
// @lc code=end

