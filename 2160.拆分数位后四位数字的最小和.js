/*
 * @lc app=leetcode.cn id=2160 lang=javascript
 *
 * [2160] 拆分数位后四位数字的最小和
 */

// @lc code=start
/**
 * @param {number} num
 * @return {number}
 */
var minimumSum = function(num) {
    const digits = [];
    for (let i = 0; i < 4; i++) {
        digits.push(num % 10);
        num = Math.floor(num / 10);
    }
    digits.sort((a, b) => a - b);
    return (digits[0] + digits[1]) * 10 + (digits[2] + digits[3]);
};
// @lc code=end

