/*
 * @lc app=leetcode.cn id=416 lang=javascript
 *
 * [416] 分割等和子集
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canPartition = function(nums) {

    let sum = 0;
    for (let i of nums) {
        sum+=i;
    }
    if (sum%2 !== 0) {
        return false;
    }
    let target = sum/2;
    let dp = Array.from(Array(nums.length + 1), () => Array(target + 1).fill(false));

    for (let i = 0; i <= nums.length; i++) {
        dp[i][0] = true;
    }

    for (let i = 1; i <= nums.length; i++) {
        for (let j = 1; j <= target; j++) {
            if (j - nums[i - 1] >= 0) {
                dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
            } else {
                dp[i][j] = dp[i - 1][j];
            }
        }
    }

    return dp[nums.length][target];
};
// @lc code=end

