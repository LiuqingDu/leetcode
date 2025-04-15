/*
 * @lc app=leetcode.cn id=1523 lang=javascript
 *
 * [1523] 在区间范围内统计奇数数目
 */

// @lc code=start
/**
 * @param {number} low
 * @param {number} high
 * @return {number}
 */
var countOdds = function(low, high) {
    let res = Math.floor((high - low) / 2);
    if (high % 2 === 1 || low % 2 === 1) {
        res++;
    }
    return res;
};
// @lc code=end

