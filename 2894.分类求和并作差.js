/*
 * @lc app=leetcode.cn id=2894 lang=javascript
 *
 * [2894] 分类求和并作差
 */

// @lc code=start
/**
 * @param {number} n
 * @param {number} m
 * @return {number}
 */
var differenceOfSums = function(n, m) {
    let ans = 0;
    for (let i = 1; i <= n; i++) {
        if (i % m === 0) {
            ans -= i;
        } else {
            ans += i;
        }
    }
    return ans;
};
// @lc code=end

