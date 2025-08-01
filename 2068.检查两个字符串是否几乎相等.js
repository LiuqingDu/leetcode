/*
 * @lc app=leetcode.cn id=2068 lang=javascript
 *
 * [2068] 检查两个字符串是否几乎相等
 */

// @lc code=start
/**
 * @param {string} word1
 * @param {string} word2
 * @return {boolean}
 */
var checkAlmostEquivalent = function(word1, word2) {
    let count = new Array(26).fill(0);
    for (let i = 0; i < word1.length; i++) {
        count[word1.charCodeAt(i) - 'a'.charCodeAt(0)]++;
        count[word2.charCodeAt(i) - 'a'.charCodeAt(0)]--;
    }
    for (let i = 0; i < count.length; i++) {
        if (Math.abs(count[i]) > 3) {
            return false;
        }
    }
    return true;
};
// @lc code=end

