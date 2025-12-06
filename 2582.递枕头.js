/*
 * @lc app=leetcode.cn id=2582 lang=javascript
 *
 * [2582] 递枕头
 */

// @lc code=start
/**
 * @param {number} n
 * @param {number} time
 * @return {number}
 */
var passThePillow = function(n, time) {
    time %= (n - 1) * 2;
    return time < n ? time + 1 : n * 2 - time - 1;
};
// @lc code=end

