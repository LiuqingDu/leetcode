/*
 * @lc app=leetcode.cn id=2956 lang=javascript
 *
 * [2956] 找到两个数组中的公共元素
 */

// @lc code=start
/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var findIntersectionValues = function(nums1, nums2) {
    let res = new Array(2).fill(0);
    for (let i = 0; i < nums1.length; i++) {
        for (let j = 0; j < nums2.length; j++) {
            if (nums1[i] == nums2[j]) {
                res[0]++;
                break;
            }
        }
    }
    for (let i = 0; i < nums2.length; i++) {
        for (let j = 0; j < nums1.length; j++) {
            if (nums2[i] == nums1[j]) {
                res[1]++;
                break;
            }
        }
    }
    return res;
};
// @lc code=end

