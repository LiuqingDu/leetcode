/*
 * @lc app=leetcode.cn id=2099 lang=javascript
 *
 * [2099] 找到和最大的长度为 K 的子序列
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
var maxSubsequence = function(nums, k) {
    let arr = nums.map((num, index) => ({ num, index }));
    arr.sort((a, b) => b.num - a.num);
    arr = arr.slice(0, k);
    arr.sort((a, b) => a.index - b.index);
    return arr.map(item => item.num);
};
// @lc code=end

