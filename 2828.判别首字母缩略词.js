/*
 * @lc app=leetcode.cn id=2828 lang=javascript
 *
 * [2828] 判别首字母缩略词
 */

// @lc code=start
/**
 * @param {string[]} words
 * @param {string} s
 * @return {boolean}
 */
var isAcronym = function(words, s) {
    if (words.length != s.length) {
        return false;
    }
    for (let i = 0; i < s.length; i++) {
        if (words[i][0] != s[i]) {
            return false;
        }
    }
    return true;
};
// @lc code=end

