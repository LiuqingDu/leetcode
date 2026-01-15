/*
 * @lc app=leetcode.cn id=1014 lang=javascript
 *
 * [1014] 最佳观光组合
 */

// @lc code=start
/**
 * @param {number[]} values
 * @return {number}
 */
var maxScoreSightseeingPair = function(values) {
    let ans = 0;
    let mx = values[0] + 0;
    for (let j = 1; j < values.length; ++j) {
        ans = Math.max(ans, mx + values[j] - j);
        // 边遍历边维护
        mx = Math.max(mx, values[j] + j);
    }
    return ans;
};
// @lc code=end

