/*
 * @lc app=leetcode.cn id=926 lang=javascript
 *
 * [926] 将字符串翻转到单调递增
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var minFlipsMonoIncr = function(s) {
    const fn = (c, target) => c === target ? 0 : 1;
    const n = s.length;
    const dp = new Array(n + 1).fill(0).map(() => new Array(2).fill(0));
    for (let i = 1; i <= n; i++) {
        const c = s[i - 1];
        dp[i][0] = dp[i - 1][0] + fn(c, '0');
        dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + fn(c, '1');
    }
    return Math.min(dp[n][0], dp[n][1]);
};
// @lc code=end

