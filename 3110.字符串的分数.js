/*
 * @lc app=leetcode.cn id=3110 lang=javascript
 *
 * [3110] 字符串的分数
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var scoreOfString = function(s) {
    let res = 0;
    
    for (let i = 0; i < s.length - 1; i++) {
        res += Math.abs(s.charCodeAt(i) - s.charCodeAt(i + 1));
    }
    return res;
};
// @lc code=end

