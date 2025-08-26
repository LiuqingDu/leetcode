/*
 * @lc app=leetcode.cn id=2144 lang=javascript
 *
 * [2144] 打折购买糖果的最小开销
 */

// @lc code=start
/**
 * @param {number[]} cost
 * @return {number}
 */
var minimumCost = function(cost) {
    cost.sort((a, b) => b - a);
    let total = 0;
    for (let i = 0; i < cost.length; i++) {
        if ((i + 1) % 3 !== 0) {
        total += cost[i];
        }
    }
    return total;
};
// @lc code=end

