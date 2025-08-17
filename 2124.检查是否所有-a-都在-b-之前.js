/*
 * @lc app=leetcode.cn id=2124 lang=javascript
 *
 * [2124] 检查是否所有 A 都在 B 之前
 */

// @lc code=start
/**
 * @param {string} s
 * @return {boolean}
 */
var checkString = function(s) {
    let bSeen = false;
    for (let char of s) {
        if (char === 'b') {
            bSeen = true;
        } else if (char === 'a' && bSeen) {
            return false;
        }
    }
    return true;
};
// @lc code=end

