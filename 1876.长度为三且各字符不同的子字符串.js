/*
 * @lc app=leetcode.cn id=1876 lang=javascript
 *
 * [1876] 长度为三且各字符不同的子字符串
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var countGoodSubstrings = function(s) {
    let count = 0;

    for (let i = 0; i <= s.length - 3; i++) {
        const a = s[i], b = s[i + 1], c = s[i + 2];
        if (a !== b && a !== c && b !== c) {
            count++;
        }
    }

    return count;
};
// @lc code=end

