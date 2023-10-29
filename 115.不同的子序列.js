/*
 * @lc app=leetcode.cn id=115 lang=javascript
 *
 * [115] 不同的子序列
 */

// @lc code=start
/**
 * @param {string} s
 * @param {string} t
 * @return {number}
 */
var numDistinct = function(s, t) {

    let m = s.length, n = t.length;

    let dp = [];
    for (let i = 0; i <= m; i++) {
        dp[i] = [];
    }

    for (let i = 0; i <= n; i++) {
        dp[0][i] = 0;
    }
    for (let i = 0; i <= m; i++) {
        dp[i][0] = 1;
    }

    for (let i = 1; i <= m; i++) {
        for (let j = 1; j <= n; j++) {
            if (s.charAt(i - 1) === t.charAt(j - 1)) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            } else {
                dp[i][j] = dp[i - 1][j];
            }
        }
    }

    return dp[m][n];

};
// @lc code=end

