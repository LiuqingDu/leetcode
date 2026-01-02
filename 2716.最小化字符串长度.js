/*
 * @lc app=leetcode.cn id=2716 lang=javascript
 *
 * [2716] 最小化字符串长度
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var minimizedStringLength = function(s) {
    let mask = 0;
    for (let c of s) {
        mask |= 1 << (c.charCodeAt(0) - 'a'.charCodeAt(0));
    }
    return mask.toString(2).split('0').join('').length;
};
// @lc code=end

