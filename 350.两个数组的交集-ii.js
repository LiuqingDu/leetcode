/*
 * @lc app=leetcode.cn id=350 lang=javascript
 *
 * [350] 两个数组的交集 II
 */

// @lc code=start
/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var intersect = function(nums1, nums2) {

    nums1 = nums1.sort((a, b) => a - b);
    nums2 = nums2.sort((a, b) => a - b);
    let i = 0, j = 0;
    let m = nums1.length, n = nums2.length;
    let res = [];

    while (i < m && j < n) {
        if (nums1[i] === nums2[j]) {
            res.push(nums1[i]);
            i++;
            j++;
        } else {
            if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
    }
    return res;
};
// @lc code=end

