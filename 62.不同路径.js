/*
 * @lc app=leetcode.cn id=62 lang=javascript
 *
 * [62] 不同路径
 */

// @lc code=start
/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var uniquePaths = function(m, n) {

    let dp = Array.from(Array(m), () => Array(n).fill(0));

    for (let i = m - 1; i >=0; i--) {
        for (let j = n - 1; j >= 0; j--) {
            if (i === m - 1 && j === n - 1) {
                dp[i][j] = 1;
            } else {
                let right = 0;
                let bottom = 0;
                if (i < m - 1) {
                    bottom = dp[i + 1][j];
                }
                if (j < n - 1) {
                    right = dp[i][j + 1];
                }
                dp[i][j] = right + bottom;
            }
        }
    }

    return dp[0][0];
};
// @lc code=end

