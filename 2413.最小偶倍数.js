/*
 * @lc app=leetcode.cn id=2413 lang=javascript
 *
 * [2413] 最小偶倍数
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var smallestEvenMultiple = function(n) {
    return n % 2 == 0 ? n : n * 2;
};
// @lc code=end

