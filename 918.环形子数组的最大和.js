/*
 * @lc app=leetcode.cn id=918 lang=javascript
 *
 * [918] 环形子数组的最大和
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubarraySumCircular = function(nums) {
    
    let total = 0;

    let maxSum = nums[0];
    let curMax = 0;

    let minSum = nums[0];
    let curMin = 0;

    for (let num of nums) {
        // 最大子数组和
        curMax = Math.max(curMax + num, num);
        maxSum = Math.max(maxSum, curMax);

        // 最小子数组和
        curMin = Math.min(curMin + num, num);
        minSum = Math.min(minSum, curMin);

        total += num;
    }

    // 全负数情况
    if (maxSum < 0) {
        return maxSum;
    }

    return Math.max(maxSum, total - minSum);
};
// @lc code=end

