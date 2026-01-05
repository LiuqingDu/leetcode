/*
 * @lc app=leetcode.cn id=2733 lang=javascript
 *
 * [2733] 既不是最小值也不是最大值
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var findNonMinOrMax = function(nums) {
    if (nums.length < 3) {
        return -1;
    }
    return nums.slice(0, 3).sort((a, b) => a - b)[1];
};
// @lc code=end

