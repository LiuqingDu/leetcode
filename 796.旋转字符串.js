/*
 * @lc app=leetcode.cn id=796 lang=javascript
 *
 * [796] 旋转字符串
 */

// @lc code=start
/**
 * @param {string} s
 * @param {string} goal
 * @return {boolean}
 */
var rotateString = function(s, goal) {
    if (s.length !== goal.length) {
        return false;
    }
    let n = s.length;

    s = s + s;
    for (let i = 0; i < n; i++) {
        if (s.substring(i, i + n) === goal) {
            return true;
        }
    }
    return false;

};
// @lc code=end

