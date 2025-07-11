/*
 * @lc app=leetcode.cn id=910 lang=javascript
 *
 * [910] 最小差值 II
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var smallestRangeII = function(nums, k) {
    nums.sort((a, b) => a - b);
    const n = nums.length;
    let min = nums[0];
    let max = nums[n - 1];
    let res = max - min;

    for (let i = 0; i < n - 1; i++) {
        const newMin = Math.min(min + k, nums[i + 1] - k);
        const newMax = Math.max(max - k, nums[i] + k);
        res = Math.min(res, newMax - newMin);
    }

    return res;
};
// @lc code=end

