/*
 * @lc app=leetcode.cn id=120 lang=javascript
 *
 * [120] 三角形最小路径和
 */

// @lc code=start
/**
 * @param {number[][]} triangle
 * @return {number}
 */
var minimumTotal = function(triangle) {

    let n = triangle.length;
    let dp = Array(n).fill(Number.MAX_VALUE);

    dp[0] = triangle[0][0];

    for (let i = 1; i < n; i++) {
        for (let j = i; j >= 0; j--) {
            dp[j] = Math.min(j ? dp[j - 1] : Number.MAX_VALUE, dp[j]) + triangle[i][j];
        }
    }

    let res = Number.MAX_VALUE;
    for (let i = 0; i < n; i++) {
        res = Math.min(res, dp[i]);
    }

    return res;

};
// @lc code=end

