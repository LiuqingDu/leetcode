/*
 * @lc app=leetcode.cn id=848 lang=javascript
 *
 * [848] 字母移位
 */

// @lc code=start
/**
 * @param {string} s
 * @param {number[]} shifts
 * @return {string}
 */
var shiftingLetters = function(s, shifts) {
    const n = s.length;
    const result = new Array(n);
    let totalShift = 0;

    for (let i = n - 1; i >= 0; i--) {
        totalShift += shifts[i];
        result[i] = String.fromCharCode(((s.charCodeAt(i) - 'a'.charCodeAt(0) + totalShift) % 26) + 'a'.charCodeAt(0));
    }

    return result.join('');
};
// @lc code=end

