/*
 * @lc app=leetcode.cn id=896 lang=javascript
 *
 * [896] 单调数列
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {boolean}
 */
var isMonotonic = function(nums) {
    let n = nums.length;
    if (n <= 2) {
        return true;
    }
    let diff = 0;
    for (let i = 1; i < n; i++) {
        if (diff === 0) {
            diff = nums[i] - nums[i - 1];
            continue;
        }
        if (diff * (nums[i] - nums[i - 1]) < 0) {
            return false;
        }
    }
    return true;
};
// @lc code=end

