/*
 * @lc app=leetcode.cn id=2864 lang=javascript
 *
 * [2864] 最大二进制奇数
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string}
 */
var maximumOddBinaryNumber = function(s) {
    let ones = 0, zeros = 0;

    // 统计 1 和 0
    for (let ch of s) {
        if (ch === '1') ones++;
        else zeros++;
    }

    // 前面：ones - 1 个 1
    // 中间：zeros 个 0
    // 最后：1 个 1
    return '1'.repeat(ones - 1) + '0'.repeat(zeros) + '1';
};
// @lc code=end

