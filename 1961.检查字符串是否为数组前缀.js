/*
 * @lc app=leetcode.cn id=1961 lang=javascript
 *
 * [1961] 检查字符串是否为数组前缀
 */

// @lc code=start
/**
 * @param {string} s
 * @param {string[]} words
 * @return {boolean}
 */
var isPrefixString = function(s, words) {
    let current = "";

    for (let word of words) {
        current += word;
        if (current.length >= s.length) {
            break;
        }
    }

    return current === s;
};
// @lc code=end

