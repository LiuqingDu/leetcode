/*
 * @lc app=leetcode.cn id=2027 lang=javascript
 *
 * [2027] 转换字符串的最少操作次数
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var minimumMoves = function(s) {
    let count = 0;
    for (let i = 0; i < s.length; i++) {
        if (s[i] === 'X') {
            count++;
            i += 2;
        }
    }
    return count;
};
// @lc code=end

