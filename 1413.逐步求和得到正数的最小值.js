/*
 * @lc app=leetcode.cn id=1413 lang=javascript
 *
 * [1413] 逐步求和得到正数的最小值
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var minStartValue = function(nums) {
    let sum = nums[0];
    let min = sum;
    for (let i = 1; i < nums.length; i++) {
        sum += nums[i];
        min = Math.min(min, sum);
    }
    return Math.max(1 - min, 1);
};
// @lc code=end

