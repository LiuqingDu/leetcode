/*
 * @lc app=leetcode.cn id=504 lang=javascript
 *
 * [504] 七进制数
 */

// @lc code=start
/**
 * @param {number} num
 * @return {string}
 */
var convertToBase7 = function(num) {
    let flag = num < 0;
    if (flag) {
        num = -num;
    }
    let res = "";
    do {
        res += num % 7;
        num = Math.floor(num / 7);
    } while (num !== 0);
    res = res.split("").reverse().join("");
    return flag ? "-" + res : res;
};
// @lc code=end

