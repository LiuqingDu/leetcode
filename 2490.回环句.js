/*
 * @lc app=leetcode.cn id=2490 lang=javascript
 *
 * [2490] 回环句
 */

// @lc code=start
/**
 * @param {string} sentence
 * @return {boolean}
 */
var isCircularSentence = function(sentence) {
    const n = sentence.length;
    if (sentence[n - 1] !== sentence[0]) {
        return false;
    }
    for (let i = 0; i < n; i++) {
        if (sentence[i] === ' ' && sentence[i + 1] !== sentence[i - 1]) {
            return false;
        }
    }
    return true;
};
// @lc code=end

