/*
 * @lc app=leetcode.cn id=507 lang=javascript
 *
 * [507] 完美数
 */

// @lc code=start
/**
 * @param {number} num
 * @return {boolean}
 */
var checkPerfectNumber = function(num) {
    if (num === 1) {
        return false;
    }
    let res = 1;
    for (let i = 2; i <= Math.floor(num / i); i++) {
        if (num % i === 0) {
            res += i;
            // 这里num已经可以整除i了，num/i一定是整数
            if (num / i != i) {
                res += num / i;
            }
        }
    }
    return res === num;

};
// @lc code=end

