/*
 * @lc app=leetcode.cn id=2544 lang=javascript
 *
 * [2544] 交替数字和
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var alternateDigitSum = function(n) {
    let res = 0, sign = 1;
    while (n > 0) {
        res += n % 10 * sign;
        sign = -sign;
        n = Math.floor(n / 10);
    }
    return -sign * res;
};
// @lc code=end

