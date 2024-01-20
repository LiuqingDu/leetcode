/*
 * @lc app=leetcode.cn id=931 lang=javascript
 *
 * [931] 下降路径最小和
 */

// @lc code=start
/**
 * @param {number[][]} matrix
 * @return {number}
 */
var minFallingPathSum = function(matrix) {

    let n = matrix.length;
    let dp = Array.from(Array(n), () => Array(n).fill(Number.MAX_VALUE));

    for (let i = 0; i < n; i++) {
        dp[0][i] = matrix[0][i];
    }

    for (let i = 1; i < n; i++) {
        for (let j = 0; j < n; j++) {
            let min = dp[i - 1][j];
            if (j > 0) {
                min = Math.min(min, dp[i - 1][j - 1]);
            }
            if (j < n - 1) {
                min = Math.min(min, dp[i - 1][j + 1]);
            }
            dp[i][j] = min + matrix[i][j];
        }
    }

    let res = Number.MAX_VALUE;
    for (let i = 0; i < n; i++) {
        res = Math.min(res, dp[n - 1][i]);
    }

    return res;
};
// @lc code=end

