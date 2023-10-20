/*
 * @lc app=leetcode.cn id=53 lang=javascript
 *
 * [53] 最大子数组和
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {

    let n = nums.length;

    let dp = [];

    dp[0] = nums[0];

    let res = dp[0];

    for (let i = 1; i < n; i++) {
        if (dp[i - 1] <= 0) {
            dp[i] = nums[i];
        } else {
            dp[i] = dp[i - 1] + nums[i];
        }
        res = Math.max(res, dp[i]);
    }

    return res;
};
// @lc code=end

