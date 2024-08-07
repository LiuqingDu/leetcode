/*
 * @lc app=leetcode.cn id=598 lang=javascript
 *
 * [598] 区间加法 II
 */

// @lc code=start
/**
 * @param {number} m
 * @param {number} n
 * @param {number[][]} ops
 * @return {number}
 */
var maxCount = function(m, n, ops) {
    for (let op of ops) {
        m = Math.min(m, op[0]);
        n = Math.min(n, op[1]);
    }

    return m * n;
};
// @lc code=end

