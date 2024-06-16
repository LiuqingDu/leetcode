/*
 * @lc app=leetcode.cn id=461 lang=javascript
 *
 * [461] 汉明距离
 */

// @lc code=start
/**
 * @param {number} x
 * @param {number} y
 * @return {number}
 */
var hammingDistance = function(x, y) {
    let res = 0;
    while ((x | y) > 0) {
        let a = x & 1, b = y & 1;
        res += a ^ b;
        x >>= 1;
        y >>= 1;
    }
    return res;
};
// @lc code=end

