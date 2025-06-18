/*
 * @lc app=leetcode.cn id=1941 lang=javascript
 *
 * [1941] 检查是否所有字符出现次数相同
 */

// @lc code=start
/**
 * @param {string} s
 * @return {boolean}
 */
var areOccurrencesEqual = function(s) {
    const count = new Array(26).fill(0);
    for (let char of s) {
        count[char.charCodeAt(0) - 'a'.charCodeAt(0)]++;
    }
    let freq = 0;
    for (let c of count) {
        if (c !== 0) {
            if (freq === 0) {
                freq = c;
            } else if (c !== freq) {
                return false;
            }
        }
    }
    return true;
};
// @lc code=end

