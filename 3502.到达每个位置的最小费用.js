/*
 * @lc app=leetcode.cn id=3502 lang=javascript
 *
 * [3502] 到达每个位置的最小费用
 */

// @lc code=start
/**
 * @param {number[]} cost
 * @return {number[]}
 */
var minCosts = function(cost) {
    for (let i = 1; i < cost.length; i++) {
        cost[i] = Math.min(cost[i], cost[i - 1]);
    }
    return cost;
};
// @lc code=end

