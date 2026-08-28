/*
 * @lc app=leetcode.cn id=3151 lang=javascript
 *
 * [3151] 特殊数组 I
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {boolean}
 */
var isArraySpecial = function(nums) {
    const n = nums.length;
    for (let i = 1; i < n; ++i) {
        if (nums[i - 1] % 2 == nums[i] % 2) {
            return false;
        }
    }
    return true;

};
// @lc code=end

