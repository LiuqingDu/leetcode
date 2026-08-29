/*
 * @lc app=leetcode.cn id=3264 lang=javascript
 *
 * [3264] K 次乘运算后的最终数组 I
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @param {number} multiplier
 * @return {number[]}
 */
var getFinalState = function(nums, k, multiplier) {
    for (let i = 0; i < k; i++) {
        let m = 0;
        for (let j = 1; j < nums.length; j++) {
            if (nums[j] < nums[m]) {
                m = j;
            }
        }
        nums[m] *= multiplier;
    }
    return nums;
};
// @lc code=end

