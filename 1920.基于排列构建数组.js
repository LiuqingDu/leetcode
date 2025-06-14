/*
 * @lc app=leetcode.cn id=1920 lang=javascript
 *
 * [1920] 基于排列构建数组
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var buildArray = function(nums) {
    const n = nums.length;
    const ans = [];
    for (let i = 0; i < n; ++i) {
        ans.push(nums[nums[i]]);
    }
    return ans;
};
// @lc code=end

