/*
 * @lc app=leetcode.cn id=2843 lang=javascript
 *
 * [2843] 统计对称整数的数目
 */

// @lc code=start
/**
 * @param {number} low
 * @param {number} high
 * @return {number}
 */
var countSymmetricIntegers = function(low, high) {
    let res = 0;
    for (let a = low; a <= high; ++a) {
        if (a < 100 && a % 11 === 0) {
            res++;
        } else if (1000 <= a && a < 10000) {
            const left = Math.floor(a / 1000) + Math.floor((a % 1000) / 100);
            const right = Math.floor((a % 100) / 10) + a % 10;
            if (left === right) {
                res++;
            }
        }
    }
    return res;
};
// @lc code=end

