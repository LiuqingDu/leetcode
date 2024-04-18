/*
 * @lc app=leetcode.cn id=343 lang=javascript
 *
 * [343] 整数拆分
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var integerBreak = function(n) {

    if (n <= 3) {
        return n - 1;
    }

    let a = Math.floor(n / 3), b = n % 3;
    if (b === 0) {
        return Math.pow(3, a);
    } else if (b === 1) {
        return Math.pow(3, a - 1) * 2 * 2;
    } else {
        return Math.pow(3, a) * 2
    }

};
// @lc code=end

