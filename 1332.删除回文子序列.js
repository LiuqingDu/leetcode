/*
 * @lc app=leetcode.cn id=1332 lang=javascript
 *
 * [1332] 删除回文子序列
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var removePalindromeSub = function(s) {
    const n = s.length;
    for (let i = 0; i < Math.floor(n / 2); ++i) {
        if (s[i] !== s[n - 1 - i]) {
            return 2;
        }
    }
    return 1;
};
// @lc code=end

