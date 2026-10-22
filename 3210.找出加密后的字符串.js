/*
 * @lc app=leetcode.cn id=3210 lang=javascript
 *
 * [3210] 找出加密后的字符串
 */

// @lc code=start
/**
 * @param {string} s
 * @param {number} k
 * @return {string}
 */
var getEncryptedString = function(s, k) {
    k %= s.length;
    return s.slice(k) + s.slice(0, k);
};
// @lc code=end

