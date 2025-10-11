/*
 * @lc app=leetcode.cn id=2309 lang=javascript
 *
 * [2309] 兼具大小写的最好英文字母
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string}
 */
var greatestLetter = function(s) {
    const set = new Set(s);
    for (let i = 25; i >= 0; i--) {
        const upper = String.fromCharCode(65 + i);
        const lower = String.fromCharCode(97 + i);
        if (set.has(upper) && set.has(lower)) {
            return upper;
        }
    }
    return '';
};
// @lc code=end

