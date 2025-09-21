/*
 * @lc app=leetcode.cn id=2255 lang=javascript
 *
 * [2255] 统计是给定字符串前缀的字符串数目
 */

// @lc code=start
/**
 * @param {string[]} words
 * @param {string} s
 * @return {number}
 */
var countPrefixes = function(words, s) {
    let count = 0;
    for (const word of words) {
        if (s.startsWith(word)) {
            count++;
        }
    }
    return count;
};
// @lc code=end

