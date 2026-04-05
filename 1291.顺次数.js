/*
 * @lc app=leetcode.cn id=1291 lang=javascript
 *
 * [1291] 顺次数
 */

// @lc code=start
/**
 * @param {number} low
 * @param {number} high
 * @return {number[]}
 */
var sequentialDigits = function(low, high) {
    const res = [];
    const str = "123456789";

    for (let len = 2; len <= 9; len++) {
        for (let i = 0; i + len <= 9; i++) {
            const num = parseInt(str.substring(i, i + len));

            if (num >= low && num <= high) {
                res.push(num);
            }
        }
    }
    return res.sort((a, b) => a - b);
};
// @lc code=end

