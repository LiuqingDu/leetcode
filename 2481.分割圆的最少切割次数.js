/*
 * @lc app=leetcode.cn id=2481 lang=javascript
 *
 * [2481] 分割圆的最少切割次数
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var numberOfCuts = function(n) {
    if (n === 1) {
        return 0;
    }
    if (n % 2 === 0) {
        return n / 2;
    }
    return n;
};
// @lc code=end

