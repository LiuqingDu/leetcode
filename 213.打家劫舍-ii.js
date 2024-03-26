/*
 * @lc app=leetcode.cn id=213 lang=javascript
 *
 * [213] 打家劫舍 II
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {

    // lc198
    let robsub = function(nums) {
        let n = nums.length;
        if (n === 1) {
            return nums[0];
        }
        if (n === 2) {
            return Math.max(nums[0], nums[1]);
        }
        let dp = Array(n).fill(0);
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (let i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[n - 1];
    }

    if (nums.length === 1) {
        return nums[0];
    }

    return Math.max(robsub(nums.slice(0, -1)), robsub(nums.slice(1)));

};
// @lc code=end

