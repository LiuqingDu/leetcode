/*
 * @lc app=leetcode.cn id=268 lang=javascript
 *
 * [268] 丢失的数字
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var missingNumber = function(nums) {

    let sum = nums.reduce((pre, cur) => pre + cur);
    let total = (0 + nums.length) * (nums.length + 1) / 2;

    return total - sum;
};
// @lc code=end

