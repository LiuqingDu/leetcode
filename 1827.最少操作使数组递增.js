/*
 * @lc app=leetcode.cn id=1827 lang=javascript
 *
 * [1827] 最少操作使数组递增
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var minOperations = function(nums) {
    let res = 0;
    let n = nums.length;
    for (let i = 1; i < n; i++) {
        if (nums[i] <= nums[i - 1]) {
            res += nums[i - 1] - nums[i] + 1;
            nums[i] = nums[i - 1] + 1;
        }
    }
    return res;
};
// @lc code=end

