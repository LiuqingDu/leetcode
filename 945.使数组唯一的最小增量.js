/*
 * @lc app=leetcode.cn id=945 lang=javascript
 *
 * [945] 使数组唯一的最小增量
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var minIncrementForUnique = function(nums) {
    let res = 0;
    nums.sort((a, b) => a - b);
    for (let i = 1; i < nums.length; i++) {
        if (nums[i] <= nums[i - 1]) {
            res += nums[i - 1] + 1 - nums[i];
            nums[i] = nums[i - 1] + 1;
        }
    }
    return res;
};
// @lc code=end

