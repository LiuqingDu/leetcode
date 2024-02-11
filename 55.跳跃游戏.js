/*
 * @lc app=leetcode.cn id=55 lang=javascript
 *
 * [55] 跳跃游戏
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump = function(nums) {

    let n = nums.length;
    let dp = Array(n).fill(false);
    dp[0] = true;
    
    for (let i = 0; i < n; i++) {
        if (!dp[i]) {
            break;
        }
        for (let j = 0; j <= nums[i] && i + j < n; j++) {
            dp[i + j] = true;
        }
    }

    return dp[n - 1];

};
// @lc code=end

