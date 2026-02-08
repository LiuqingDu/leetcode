/*
 * @lc app=leetcode.cn id=1029 lang=javascript
 *
 * [1029] 两地调度
 */

// @lc code=start
/**
 * @param {number[][]} costs
 * @return {number}
 */
var twoCitySchedCost = function(costs) {
    const n = costs.length / 2;

    // 按 (去B - 去A) 的差价排序
    costs.sort((a, b) => (a[1] - a[0]) - (b[1] - b[0]));

    let total = 0;

    for (let i = 0; i < costs.length; i++) {
        if (i < n) {
            total += costs[i][1]; // 前 n 个去 B
        } else {
            total += costs[i][0]; // 后 n 个去 A
        }
    }

    return total;
};
// @lc code=end

