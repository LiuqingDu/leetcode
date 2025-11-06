/*
 * @lc app=leetcode.cn id=2427 lang=javascript
 *
 * [2427] 公因子的数目
 */

// @lc code=start
/**
 * @param {number} a
 * @param {number} b
 * @return {number}
 */
var commonFactors = function(a, b) {
    let ans = 0;
    for (let x = 1; x <= Math.min(a, b); ++x) {
        if (a % x === 0 && b % x === 0) {
            ++ans;
        }
    }
    return ans;
};
// @lc code=end

