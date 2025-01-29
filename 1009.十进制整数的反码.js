/*
 * @lc app=leetcode.cn id=1009 lang=javascript
 *
 * [1009] 十进制整数的反码
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var bitwiseComplement = function(n) {
    let mask = 1;
    while (mask < n) {
        mask = (mask << 1) + 1;
    }

    return mask ^ n;
};
// @lc code=end

