/*
 * @lc app=leetcode.cn id=1897 lang=javascript
 *
 * [1897] 重新分配字符使所有字符串都相等
 */

// @lc code=start
/**
 * @param {string[]} words
 * @return {boolean}
 */
var makeEqual = function(words) {
    const count = new Array(26).fill(0);

    for (const word of words) {
        for (const char of word) {
            count[char.charCodeAt(0) - 'a'.charCodeAt(0)]++;
        }
    }

    const n = words.length;

    for (const freq of count) {
        if (freq % n !== 0) {
            return false;
        }
    }

    return true;
};
// @lc code=end

