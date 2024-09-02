/*
 * @lc app=leetcode.cn id=908 lang=javascript
 *
 * [908] 最小差值 I
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var smallestRangeI = function(nums, k) {
    let max = nums[0], min = nums[0];
    for (let i = 0; i < nums.length; i++) {
        max = Math.max(max, nums[i]);
        min = Math.min(min, nums[i]);
    }
    let d = max - min;
    return d <= 2 * k ? 0 : d - 2 * k;
};
// @lc code=end

