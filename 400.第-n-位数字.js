/*
 * @lc app=leetcode.cn id=400 lang=javascript
 *
 * [400] 第 N 位数字
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var findNthDigit = function(n) {
    let level = 1, base = 9;
    while (n > level * base) {
        n -= level * base;
        level++;
        base *= 10;
    }

    let startNum = Math.pow(10, level - 1);
    let targetNum = startNum + Math.floor((n - 1) / level);

    let ind = (n - 1) % level;
    return String(targetNum).charAt(ind) - "0".charAt(0);
};
// @lc code=end

