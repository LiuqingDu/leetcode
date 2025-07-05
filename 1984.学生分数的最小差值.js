/*
 * @lc app=leetcode.cn id=1984 lang=javascript
 *
 * [1984] 学生分数的最小差值
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var minimumDifference = function(nums, k) {
    if (k === 0) return 0;
    nums.sort((a, b) => a - b);
    let minDiff = Infinity;

    for (let i = 0; i <= nums.length - k; i++) {
        const currentDiff = nums[i + k - 1] - nums[i];
        minDiff = Math.min(minDiff, currentDiff);
    }

    return minDiff;
};
// @lc code=end

