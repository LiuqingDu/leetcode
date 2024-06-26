/*
 * @lc app=leetcode.cn id=263 lang=javascript
 *
 * [263] 丑数
 */

// @lc code=start
/**
 * @param {number} n
 * @return {boolean}
 */
var isUgly = function(n) {
    if(n <= 0) {
        return false;
    }

    while (n % 2 === 0) {
        n = Math.floor(n / 2);
    }
    while (n % 3 === 0) {
        n = Math.floor(n / 3);
    }
    while (n % 5 === 0) {
        n = Math.floor(n / 5);
    }
    return n === 1;

};
// @lc code=end

