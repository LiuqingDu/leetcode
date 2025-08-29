/*
 * @lc app=leetcode.cn id=2154 lang=javascript
 *
 * [2154] 将找到的值乘以 2
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} original
 * @return {number}
 */
var findFinalValue = function(nums, original) {
    while (nums.includes(original)) {
        original *= 2;
    }
    return original;
};
// @lc code=end

