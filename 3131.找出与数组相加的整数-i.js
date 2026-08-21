/*
 * @lc app=leetcode.cn id=3131 lang=javascript
 *
 * [3131] 找出与数组相加的整数 I
 */

// @lc code=start
/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var addedInteger = function(nums1, nums2) {
    
    return Math.max(...nums2) - Math.max(...nums1);
};
// @lc code=end

