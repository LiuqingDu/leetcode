/*
 * @lc app=leetcode.cn id=221 lang=javascript
 *
 * [221] 最大正方形
 */

// @lc code=start
/**
 * @param {character[][]} matrix
 * @return {number}
 */
var maximalSquare = function(matrix) {

    let m = matrix.length;
    let n = matrix[0].length;

    let dp = Array.from(Array(m), () => new Array(n).fill(0));
    let res = 0;

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (matrix[i][j] === "0") {
                dp[i][j] = 0;
            } else {
                if (i === 0 || j === 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
                }
            }
            res = Math.max(res, dp[i][j]);
        }
    }

    return res * res;

};
// @lc code=end

