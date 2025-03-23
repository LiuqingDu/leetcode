/*
 * @lc app=leetcode.cn id=1446 lang=javascript
 *
 * [1446] 连续字符
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var maxPower = function(s) {
    let n = s.length;
    let res = 0;
    let left = 0, right = 0;
    while (left < n) {
        right = left;
        while (right < n && s[right] === s[left]) {
            right++;
        }
        res = Math.max(res, right - left);
        left = right;
    }
    return res;
};
// @lc code=end

