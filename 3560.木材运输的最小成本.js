/*
 * @lc app=leetcode.cn id=3560 lang=javascript
 *
 * [3560] 木材运输的最小成本
 */

// @lc code=start
/**
 * @param {number} n
 * @param {number} m
 * @param {number} k
 * @return {number}
 */
var minCuttingCost = function(n, m, k) {
    return Math.max(k * (Math.max(n, m) - k), 0);
};
// @lc code=end

