/*
 * @lc app=leetcode.cn id=795 lang=javascript
 *
 * [795] 区间子数组个数
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} left
 * @param {number} right
 * @return {number}
 */
var numSubarrayBoundedMax = function(nums, left, right) {
    let n = nums.length;
    // 在 java 版的基础上,可以只用一个数来记录
    let dp = (nums[0] >= left && nums[0] <= right) ? 1 : 0;
    let lessThanLeft = nums[0] < left ? 1 : 0;
    let res = dp;

    for (let i = 1; i < n; i++) {
        if (nums[i] > right) {
            dp = 0;
            lessThanLeft = 0;
        } else if (nums[i] < left) {
            // dp 不变
            // dp = dp
            lessThanLeft++;
        } else {
            dp = dp + 1 + lessThanLeft;
            lessThanLeft = 0;
        }
        res += dp;
    }
    return res;
};
// @lc code=end

