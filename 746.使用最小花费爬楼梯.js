/*
 * @lc app=leetcode.cn id=746 lang=javascript
 *
 * [746] 使用最小花费爬楼梯
 */

// @lc code=start
/**
 * @param {number[]} cost
 * @return {number}
 */
var minCostClimbingStairs = function(cost) {
    let n = cost.length;
    let res = new Array(n + 1).fill(0);
    for (let i = 2; i <= n; i++) {
        res[i] = Math.min(res[i - 2] + cost[i - 2], res[i - 1] + cost[i - 1]);
    }
    return res[n];
};
// @lc code=end

