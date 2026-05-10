/*
 * @lc app=leetcode.cn id=3083 lang=javascript
 *
 * [3083] 字符串及其反转中是否存在同一子字符串
 */

// @lc code=start
/**
 * @param {string} s
 * @return {boolean}
 */
var isSubstringPresent = function(s) {
    for (let i = 0; i < s.length - 1; i++) {
        let sub = s.substring(i, i + 2);
        let rev = "" + sub[1] + sub[0];

        if (s.indexOf(rev) !== -1) {
            return true;
        }
    }
    return false;
};
// @lc code=end

