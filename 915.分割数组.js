/*
 * @lc app=leetcode.cn id=915 lang=javascript
 *
 * [915] 分割数组
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var partitionDisjoint = function(nums) {
    const n = nums.length;
    let left = 0, leftMax = nums[0], curMax = nums[0];
    for (let i = 1; i < n - 1; i++) {
        curMax = Math.max(curMax, nums[i]);
        if (nums[i] < leftMax) {
            left = i;
            leftMax = curMax;
        }
    }
    return left + 1;
};
// @lc code=end

