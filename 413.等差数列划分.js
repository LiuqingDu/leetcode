/*
 * @lc app=leetcode.cn id=413 lang=javascript
 *
 * [413] 等差数列划分
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var numberOfArithmeticSlices = function(nums) {
    let n = nums.length;
    if (n < 3) {
        return 0;
    }
    let dp = Array(n).fill(0);

    for (let i = 2; i < n; i++) {
        if (nums[i] - nums[i - 1] === nums[i - 1] - nums[i - 2]) {
            dp[i] = dp[i - 1] + 1;
        } else {
            dp[i] = 0;
        }
    }

    return dp.reduce((pre, cur) => pre + cur);

};
// @lc code=end

