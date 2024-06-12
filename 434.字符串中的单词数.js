/*
 * @lc app=leetcode.cn id=434 lang=javascript
 *
 * [434] 字符串中的单词数
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var countSegments = function(s) {
    let res = 0;
    let w = 0;
    for (let i = 0; i < s.length; i++) {
        if (s[i] === ' ') {
            res += w;
            w = 0;
        } else {
            w = 1;
        }
    }
    return res + w;

};
// @lc code=end

