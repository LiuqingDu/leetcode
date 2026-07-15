/*
 * @lc app=leetcode.cn id=1470 lang=javascript
 *
 * [1470] 重新排列数组
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} n
 * @return {number[]}
 */
var shuffle = function(nums, n) {
    let res = new Array(n * 2).fill(0);
    for (let i = 0; i < n; i++) {
        res[i * 2] = nums[i]
        res[i * 2 + 1] = nums[i + n];
    }
    return res;
};
// @lc code=end

