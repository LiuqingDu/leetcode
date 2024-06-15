/*
 * @lc app=leetcode.cn id=459 lang=javascript
 *
 * [459] 重复的子字符串
 */

// @lc code=start
/**
 * @param {string} s
 * @return {boolean}
 */
var repeatedSubstringPattern = function(s) {
    let str = s + s;
    str = str.substring(1, str.length - 1);
    return str.indexOf(s) !== -1;
};
// @lc code=end

