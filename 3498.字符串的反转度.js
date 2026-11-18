/*
 * @lc app=leetcode.cn id=3498 lang=javascript
 *
 * [3498] 字符串的反转度
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var reverseDegree = function(s) {
    let res = 0;
    for (let i = 1; i <= s.length; i++) {
        res += (26 - (s.charCodeAt(i - 1) - 'a'.charCodeAt(0))) * i;
    }

    return res;
};
// @lc code=end

