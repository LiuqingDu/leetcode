/*
 * @lc app=leetcode.cn id=88 lang=javascript
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function(nums1, m, nums2, n) {

    for (let i = m - 1, j = n - 1, k = m + n - 1; k >= 0; k--) {
        if (j < 0 || i >= 0 && nums1[i] >= nums2[j]) {
            nums1[k] = nums1[i--];
        } else {
            nums1[k] = nums2[j--];
        }
    }
};
// @lc code=end

