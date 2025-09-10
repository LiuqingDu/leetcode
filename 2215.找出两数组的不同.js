/*
 * @lc app=leetcode.cn id=2215 lang=javascript
 *
 * [2215] 找出两数组的不同
 */

// @lc code=start
/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[][]}
 */
var findDifference = function(nums1, nums2) {
    const set1 = new Set(nums1);
    const set2 = new Set(nums2);
    const diff1 = [...set1].filter(n => !set2.has(n));
    const diff2 = [...set2].filter(n => !set1.has(n));
    return [diff1, diff2];
};
// @lc code=end

