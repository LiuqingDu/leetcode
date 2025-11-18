/*
 * @lc app=leetcode.cn id=2485 lang=javascript
 *
 * [2485] 找出中枢整数
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var pivotInteger = function(n) {
    let t = (n * n + n) / 2;
    let x = parseInt(Math.sqrt(t));
    if (x * x === t) {
        return x;
    }
    return -1;
};
// @lc code=end

