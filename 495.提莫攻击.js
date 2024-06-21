/*
 * @lc app=leetcode.cn id=495 lang=javascript
 *
 * [495] 提莫攻击
 */

// @lc code=start
/**
 * @param {number[]} timeSeries
 * @param {number} duration
 * @return {number}
 */
var findPoisonedDuration = function(timeSeries, duration) {
    let res = 0, last = -1;
    for (let s of timeSeries) {
        let i = s + duration - 1;
        if (last < s) {
            res += duration;
        } else {
            res += i - last;
        }
        last = i;
    }
    return res;
};
// @lc code=end

