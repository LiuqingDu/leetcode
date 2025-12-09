/*
 * @lc app=leetcode.cn id=2595 lang=javascript
 *
 * [2595] 奇偶位数
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number[]}
 */
var evenOddBit = function(n) {
    const res = [0, 0];
    let i = 0;
    while (n > 0) {
        res[i] += n & 1;
        n >>= 1;
        i ^= 1;
    }
    return res;
};
// @lc code=end

