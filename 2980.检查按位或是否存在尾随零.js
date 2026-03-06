/*
 * @lc app=leetcode.cn id=2980 lang=javascript
 *
 * [2980] 检查按位或是否存在尾随零
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {boolean}
 */
var hasTrailingZeros = function(nums) {
    let count = 0;
    for (let num of nums) {
        if ((num & 1) === 0) {
            count++;
        }
    }
    return count >= 2;
};
// @lc code=end

