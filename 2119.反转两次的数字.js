/*
 * @lc app=leetcode.cn id=2119 lang=javascript
 *
 * [2119] 反转两次的数字
 */

// @lc code=start
/**
 * @param {number} num
 * @return {boolean}
 */
var isSameAfterReversals = function(num) {
    return num === 0 || num % 10 !== 0;
};
// @lc code=end

