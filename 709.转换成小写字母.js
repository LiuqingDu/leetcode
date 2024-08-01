/*
 * @lc app=leetcode.cn id=709 lang=javascript
 *
 * [709] 转换成小写字母
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string}
 */
var toLowerCase = function(s) {
    let res = "";
    for (let c of s) {
        if (c.charCodeAt(0) >= 65 && c.charCodeAt(0) <= 90) {
            c = String.fromCharCode(c.charCodeAt(0) | 32);
        }
        res += c;
    }
    return res;
};
// @lc code=end

