/*
 * @lc app=leetcode.cn id=3959 lang=javascript
 *
 * [3959] 判定好整数
 */

// @lc code=start
/**
 * @param {number} n
 * @return {boolean}
 */
var checkGoodInteger = function(n) {
    let diff = 0;
    for (; n > 0;) {
        let d = n % 10;
        diff += d * d - d;
        n = Math.floor(n / 10);
    }
    return diff >= 50;
};
// @lc code=end

