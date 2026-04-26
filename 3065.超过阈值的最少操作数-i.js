/*
 * @lc app=leetcode.cn id=3065 lang=javascript
 *
 * [3065] 超过阈值的最少操作数 I
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var minOperations = function(nums, k) {
    return nums.filter((num) => num < k).length;
};
// @lc code=end

