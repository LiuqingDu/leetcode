/*
 * @lc app=leetcode.cn id=365 lang=javascript
 *
 * [365] 水壶问题
 */

// @lc code=start
/**
 * @param {number} x
 * @param {number} y
 * @param {number} target
 * @return {boolean}
 */
var canMeasureWater = function(x, y, target) {
    let gcd = function(x, y) {
        let remainder = x % y;
        while (remainder !== 0) {
            x = y;
            y = remainder;
            remainder = x % y;
        }
        return y;
    }

    if (x + y < target) {
        return false;
    }

    if (x === 0 || y === 0) {
        return target === 0 || x + y === target;
    }

    return target % gcd(x, y) === 0;
};
// @lc code=end

