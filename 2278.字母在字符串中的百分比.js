/*
 * @lc app=leetcode.cn id=2278 lang=javascript
 *
 * [2278] 字母在字符串中的百分比
 */

// @lc code=start
/**
 * @param {string} s
 * @param {character} letter
 * @return {number}
 */
var percentageLetter = function(s, letter) {
    let count = 0;
    for (const char of s) {
        if (char === letter) {
            count++;
        }
    }
    return Math.floor((count / s.length) * 100);
};
// @lc code=end

