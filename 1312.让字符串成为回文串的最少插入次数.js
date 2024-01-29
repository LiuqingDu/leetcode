/*
 * @lc app=leetcode.cn id=1312 lang=javascript
 *
 * [1312] 让字符串成为回文串的最少插入次数
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var minInsertions = function(s) {

    let n = s.length;
    let dp = Array.from(Array(n), () => Array(n).fill(0));

    for (let i = 0; i < n; i++) {
        dp[i][i] = 0;
    }
    for (let i = 0; i < n - 1; i++) {
        if (s.charAt(i) === s.charAt(i + 1)) {
            dp[i][i + 1] = 0;
        } else {
            dp[i][i + 1] = 1;
        }
    }

    for (let dif = 2; dif < n; dif++) {
        for (let i = 0; i < n - dif; i++) {
            if (s.charAt(i) === s.charAt(i + dif)) {
                dp[i][i + dif] = dp[i + 1][i + dif - 1];
            } else {
                dp[i][i + dif] = Math.min(dp[i][i + dif - 1], dp[i + 1][i + dif]) + 1;
            }
        }
    }

    return dp[0][n - 1];

};
// @lc code=end

