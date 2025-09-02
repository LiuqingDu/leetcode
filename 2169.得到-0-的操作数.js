/*
 * @lc app=leetcode.cn id=2169 lang=javascript
 *
 * [2169] 得到 0 的操作数
 */

// @lc code=start
/**
 * @param {number} num1
 * @param {number} num2
 * @return {number}
 */
var countOperations = function(num1, num2) {
    let count = 0;
    while (num1 !== 0 && num2 !== 0) {
        if (num1 > num2) {
            num1 -= num2;
        } else {
            num2 -= num1;
        }
        count++;
    }
    return count;
};
// @lc code=end

