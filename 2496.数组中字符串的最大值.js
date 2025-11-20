/*
 * @lc app=leetcode.cn id=2496 lang=javascript
 *
 * [2496] 数组中字符串的最大值
 */

// @lc code=start
/**
 * @param {string[]} strs
 * @return {number}
 */
var maximumValue = function(strs) {
    let res = 0;
    for (const s of strs) {
        let isDigits = true;
        for (const c of s) {
            isDigits &= c >= '0' && c <= '9';
        }
        res = Math.max(res, isDigits ? Number(s) : s.length);
    }
    return res;
};
// @lc code=end

