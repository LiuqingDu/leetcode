/*
 * @lc app=leetcode.cn id=2465 lang=javascript
 *
 * [2465] 不同的平均值数目
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var distinctAverages = function(nums) {
    nums.sort((a, b) => a - b);
    const seen = new Set();
    for (let i = 0, j = nums.length - 1; i < j; i++, j--) {
        seen.add(nums[i] + nums[j]);
    }
    return seen.size;
};
// @lc code=end

