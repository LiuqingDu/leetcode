/*
 * @lc app=leetcode.cn id=1486 lang=javascript
 *
 * [1486] 数组异或操作
 */

// @lc code=start
/**
 * @param {number} n
 * @param {number} start
 * @return {number}
 */
var xorOperation = function(n, start) {
    let ans = 0;
    for (let i = 0; i < n; ++i) {
        ans ^= (start + i * 2);
    }
    return ans;
};
// @lc code=end

