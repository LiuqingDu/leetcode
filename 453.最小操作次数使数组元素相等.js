/*
 * @lc app=leetcode.cn id=453 lang=javascript
 *
 * [453] 最小操作次数使数组元素相等
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var minMoves = function(nums) {
    let n = nums.length;
    let min = nums[0];
    let sum = 0;
    for (let i = 0; i < n; i++) {
        min = Math.min(min, nums[i]);
        sum += nums[i];
    }
    return sum - min * n;
};
// @lc code=end

