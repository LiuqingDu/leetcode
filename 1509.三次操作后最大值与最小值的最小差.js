/*
 * @lc app=leetcode.cn id=1509 lang=javascript
 *
 * [1509] 三次操作后最大值与最小值的最小差
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var minDifference = function(nums) {
    let n = nums.length;
    if (n <= 4) {
        return 0;
    }

    nums.sort((a, b) => a - b);
    let res = Number.MAX_SAFE_INTEGER;
    for (let i = 0; i < 4; i++) {
        res = Math.min(res, nums[n - 4 + i] - nums[i]);
    }

    return res;
};
// @lc code=end

