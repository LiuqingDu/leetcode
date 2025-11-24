/*
 * @lc app=leetcode.cn id=2520 lang=javascript
 *
 * [2520] 统计能整除数字的位数
 */

// @lc code=start
/**
 * @param {number} num
 * @return {number}
 */
var countDigits = function(num) {
    let t = num;
    let res = 0;
    while (t) {
        if (num % (t % 10) == 0) {
            res += 1;
        }
        t = Math.floor(t / 10);
    }
    return res;
};
// @lc code=end

