/*
 * @lc app=leetcode.cn id=3370 lang=javascript
 *
 * [3370] 仅含置位位的最小整数
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var smallestNumber = function(n) {
    
    let x = 1;
    while (x < n) {
        x = x * 2 + 1;
    }
    return x;
};
// @lc code=end

