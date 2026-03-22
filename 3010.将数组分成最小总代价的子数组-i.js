/*
 * @lc app=leetcode.cn id=3010 lang=javascript
 *
 * [3010] 将数组分成最小总代价的子数组 I
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var minimumCost = function(nums) {
    nums = [nums[0], ...nums.slice(1).sort((a, b) => a - b)];
    return nums.slice(0, 3).reduce((sum, num) => sum + num, 0);
};
// @lc code=end

